import java.util.*;

class DNSEntry {

    String ip;
    long expiry;

    DNSEntry(String ip,long ttl){
        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl*1000;
    }

    boolean expired(){
        return System.currentTimeMillis()>expiry;
    }
}

public class DNSCache {

    HashMap<String,DNSEntry> cache=new HashMap<>();

    public String resolve(String domain){

        DNSEntry entry=cache.get(domain);

        if(entry!=null && !entry.expired())
            return "Cache HIT "+entry.ip;

        String ip="172.217.14."+new Random().nextInt(255);

        cache.put(domain,new DNSEntry(ip,300));

        return "Cache MISS "+ip;
    }

    public static void main(String[] args){

        DNSCache dns=new DNSCache();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));
    }
}