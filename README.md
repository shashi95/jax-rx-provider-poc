# jax-rx-provider-poc
This project demonstrate working of JAX-RS provider.

Steps to run this project
============================
1. Clone this project into your local machine.
    $ git clone git@github.com:shashi95/jax-rx-provider-poc.git
2. Go inside this project $cd proxy-poc
3. Make fat jar $gradle fatJar
4. This will create jar with all dependencies into build/libs folder.
5. Run this jar using server config
     $ java -jar build/libs/proxy-poc-1.0-SNAPSHOT.jar server proxy.yml
6. Now call api for 2 sellers, seller1 which belong to proxy list and seller2 which doesn't belong to proxy list.
   1. http://{elb}/test/jax/v1/{id1}/provider?param={id}&service_type={type}&sellerId={id1}
        
        This seller is not in proxy list.
        Redirecting to [OLD] es : Successfully continued the flow!!
   
   2. http://{elb}/test/jax/v1/{id1}/provider?param={id}&service_type={type}&sellerId={id1}
         
         Response: This is not in proxy list, so redirecting to new es.
         [NEW URL]: complete URL
         actul json response.
        
7. Thats all!!. :)
    

