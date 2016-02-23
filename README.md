# Sample code to use Byteman and JBoss

This repo contains an example to show how to use Byteman in JBoss to inspect all object injected into the WebSession.
The Byteman Helper checks if object is Serialiable or not.

## First compile ByteMan Helper  

```
  cd ExtractGrape
  mvn clean package
```

## Second compile sample application

```
  cd helloworld
  mvn clean package
```

## Runtime

Copy the War file to the JBoss `deployement` directory
Modify `standalone.conf` like this 



## Result 

You should get an output like this when you call <http://127.0.0.1:8080/jboss-helloworld/Session?name=toto3>


```
18:01:53,957 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.byteman.agent.Transformer : possible trigger for rule introspect in class org.apache.catalina.session.StandardSessionFacade
18:01:53,968 INFO  [stdout] (http-/127.0.0.1:8080-1) RuleTriggerMethodAdapter.injectTriggerPoint : inserting trigger into org.apache.catalina.session.StandardSessionFacade.setAttribute(java.lang.String,java.lang.Object) void for rule introspect
18:01:53,973 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.byteman.agent.Transformer : inserted trigger for introspect in class org.apache.catalina.session.StandardSessionFacade
18:01:53,975 INFO  [stdout] (http-/127.0.0.1:8080-1) Rule.execute called for introspect_0
18:01:53,981 INFO  [stdout] (http-/127.0.0.1:8080-1) HelperManager.install for helper class net.a.g.ExtractGrape
18:01:53,982 INFO  [stdout] (http-/127.0.0.1:8080-1) calling activated() for helper class net.a.g.ExtractGrape
18:01:53,982 INFO  [stdout] (http-/127.0.0.1:8080-1) Default helper activated
18:01:53,982 INFO  [stdout] (http-/127.0.0.1:8080-1) calling installed(introspect) for helper classnet.a.g.ExtractGrape
18:01:53,983 INFO  [stdout] (http-/127.0.0.1:8080-1) Installed rule using default helper : introspect
18:01:53,983 INFO  [stdout] (http-/127.0.0.1:8080-1) introspect execute()
18:01:53,984 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Call 'setAttribute([java.lang.String] userName ,[java.lang.String] toto)
18:01:53,985 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Stack Trace!
18:01:53,985 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.session.StandardSessionFacade.setAttribute(StandardSessionFacade.java:-1)
18:01:53,985 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.as.quickstarts.helloworld.HelloWorldSessionServlet.doGet(HelloWorldSessionServlet.java:61)
18:01:53,985 INFO  [stdout] (http-/127.0.0.1:8080-1) javax.servlet.http.HttpServlet.service(HttpServlet.java:734)
18:01:53,985 INFO  [stdout] (http-/127.0.0.1:8080-1) javax.servlet.http.HttpServlet.service(HttpServlet.java:847)
18:01:53,985 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:295)
18:01:53,985 INFO  [stdout] (http-/127.0.0.1:8080-1)   . . .
18:01:53,986 INFO  [stdout] (http-/127.0.0.1:8080-1) Rule.execute called for introspect_0
18:01:53,986 INFO  [stdout] (http-/127.0.0.1:8080-1) introspect execute()
18:01:53,987 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Call 'setAttribute([java.lang.String] bean ,[org.jboss.as.quickstarts.helloworld.TestBean] org.jboss.as.quickstarts.helloworld.TestBean@7f0f482)
18:01:53,987 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Stack Trace!
18:01:53,987 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.session.StandardSessionFacade.setAttribute(StandardSessionFacade.java:-1)
18:01:53,988 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.as.quickstarts.helloworld.HelloWorldSessionServlet.doGet(HelloWorldSessionServlet.java:64)
18:01:53,988 INFO  [stdout] (http-/127.0.0.1:8080-1) javax.servlet.http.HttpServlet.service(HttpServlet.java:734)
18:01:53,988 INFO  [stdout] (http-/127.0.0.1:8080-1) javax.servlet.http.HttpServlet.service(HttpServlet.java:847)
18:01:53,988 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:295)
18:01:53,988 INFO  [stdout] (http-/127.0.0.1:8080-1)   . . .
18:01:53,988 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan org.jboss.as.quickstarts.helloworld.TestBean Serializable KO
18:01:54,027 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan org.jboss.as.quickstarts.helloworld.TestBean2 Serializable OK
18:01:54,030 INFO  [stdout] (http-/127.0.0.1:8080-1) Rule.execute called for introspect_0
18:01:54,031 INFO  [stdout] (http-/127.0.0.1:8080-1) introspect execute()
18:01:54,031 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Call 'setAttribute([java.lang.String] org.jboss.weld.context.conversation.ConversationIdGenerator ,[org.jboss.weld.context.conversation.ConversationIdGenerator] org.jboss.weld.context.conversation.ConversationIdGenerator@66641159)
18:01:54,031 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Stack Trace!
18:01:54,032 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.session.StandardSessionFacade.setAttribute(StandardSessionFacade.java:-1)
18:01:54,032 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.weld.context.http.HttpConversationContextImpl.setSessionAttribute(HttpConversationContextImpl.java:17)
18:01:54,032 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.weld.context.http.HttpConversationContextImpl.setSessionAttribute(HttpConversationContextImpl.java:12)
18:01:54,032 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.weld.context.AbstractConversationContext.dissociate(AbstractConversationContext.java:157)
18:01:54,032 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.weld.servlet.WeldListener.safelyDissociate(WeldListener.java:260)
18:01:54,032 INFO  [stdout] (http-/127.0.0.1:8080-1)   . . .
18:01:54,032 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan org.jboss.weld.context.conversation.ConversationIdGenerator Serializable OK
18:01:54,033 INFO  [stdout] (http-/127.0.0.1:8080-1) Rule.execute called for introspect_0
18:01:54,033 INFO  [stdout] (http-/127.0.0.1:8080-1) introspect execute()
18:01:54,033 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Call 'setAttribute([java.lang.String] org.jboss.weld.context.ConversationContext.conversations ,[java.util.Collections$SynchronizedMap] {})
18:01:54,033 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Stack Trace!
18:01:54,033 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.session.StandardSessionFacade.setAttribute(StandardSessionFacade.java:-1)
18:01:54,034 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.weld.context.http.HttpConversationContextImpl.setSessionAttribute(HttpConversationContextImpl.java:17)
18:01:54,034 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.weld.context.http.HttpConversationContextImpl.setSessionAttribute(HttpConversationContextImpl.java:12)
18:01:54,034 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.weld.context.AbstractConversationContext.dissociate(AbstractConversationContext.java:160)
18:01:54,034 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.weld.servlet.WeldListener.safelyDissociate(WeldListener.java:260)
18:01:54,034 INFO  [stdout] (http-/127.0.0.1:8080-1)   . . .
18:01:54,034 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan java.util.Collections$SynchronizedMap Serializable OK
18:30:05,972 INFO  [stdout] (http-/127.0.0.1:8080-1) Rule.execute called for introspect_0
18:30:05,983 INFO  [stdout] (http-/127.0.0.1:8080-1) introspect execute()
18:30:05,984 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Call 'setAttribute([java.lang.String] userName ,[java.lang.String] toto)
18:30:05,984 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Stack Trace!
18:30:05,984 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.session.StandardSessionFacade.setAttribute(StandardSessionFacade.java:-1)
18:30:05,984 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.as.quickstarts.helloworld.HelloWorldSessionServlet.doGet(HelloWorldSessionServlet.java:61)
18:30:05,984 INFO  [stdout] (http-/127.0.0.1:8080-1) javax.servlet.http.HttpServlet.service(HttpServlet.java:734)
18:30:05,985 INFO  [stdout] (http-/127.0.0.1:8080-1) javax.servlet.http.HttpServlet.service(HttpServlet.java:847)
18:30:05,985 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:295)
18:30:05,985 INFO  [stdout] (http-/127.0.0.1:8080-1)   . . .
18:30:05,985 INFO  [stdout] (http-/127.0.0.1:8080-1) Rule.execute called for introspect_0
18:30:05,985 INFO  [stdout] (http-/127.0.0.1:8080-1) introspect execute()
18:30:05,986 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Call 'setAttribute([java.lang.String] bean ,[org.jboss.as.quickstarts.helloworld.TestBean] org.jboss.as.quickstarts.helloworld.TestBean@38181778)
18:30:05,986 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Stack Trace!
18:30:05,987 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.session.StandardSessionFacade.setAttribute(StandardSessionFacade.java:-1)
18:30:05,987 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.as.quickstarts.helloworld.HelloWorldSessionServlet.doGet(HelloWorldSessionServlet.java:64)
18:30:05,987 INFO  [stdout] (http-/127.0.0.1:8080-1) javax.servlet.http.HttpServlet.service(HttpServlet.java:734)
18:30:05,987 INFO  [stdout] (http-/127.0.0.1:8080-1) javax.servlet.http.HttpServlet.service(HttpServlet.java:847)
18:30:05,987 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:295)
18:30:05,987 INFO  [stdout] (http-/127.0.0.1:8080-1)   . . .
18:30:05,987 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan org.jboss.as.quickstarts.helloworld.TestBean Serializable KO
18:30:05,988 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan org.jboss.as.quickstarts.helloworld.TestBean2 Serializable OK
18:30:19,344 INFO  [stdout] (http-/127.0.0.1:8080-1) Rule.execute called for introspect_0
18:30:19,344 INFO  [stdout] (http-/127.0.0.1:8080-1) introspect execute()
18:30:19,345 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Call 'setAttribute([java.lang.String] userName ,[java.lang.String] toto3)
18:30:19,345 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Stack Trace!
18:30:19,345 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.session.StandardSessionFacade.setAttribute(StandardSessionFacade.java:-1)
18:30:19,345 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.as.quickstarts.helloworld.HelloWorldSessionServlet.doGet(HelloWorldSessionServlet.java:61)
18:30:19,345 INFO  [stdout] (http-/127.0.0.1:8080-1) javax.servlet.http.HttpServlet.service(HttpServlet.java:734)
18:30:19,346 INFO  [stdout] (http-/127.0.0.1:8080-1) javax.servlet.http.HttpServlet.service(HttpServlet.java:847)
18:30:19,346 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:295)
18:30:19,346 INFO  [stdout] (http-/127.0.0.1:8080-1)   . . .
18:30:19,346 INFO  [stdout] (http-/127.0.0.1:8080-1) Rule.execute called for introspect_0
18:30:19,346 INFO  [stdout] (http-/127.0.0.1:8080-1) introspect execute()
18:30:19,347 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Call 'setAttribute([java.lang.String] bean ,[org.jboss.as.quickstarts.helloworld.TestBean] org.jboss.as.quickstarts.helloworld.TestBean@7c7bfc68)
18:30:19,347 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan Stack Trace!
18:30:19,347 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.session.StandardSessionFacade.setAttribute(StandardSessionFacade.java:-1)
18:30:19,348 INFO  [stdout] (http-/127.0.0.1:8080-1) org.jboss.as.quickstarts.helloworld.HelloWorldSessionServlet.doGet(HelloWorldSessionServlet.java:64)
18:30:19,348 INFO  [stdout] (http-/127.0.0.1:8080-1) javax.servlet.http.HttpServlet.service(HttpServlet.java:734)
18:30:19,348 INFO  [stdout] (http-/127.0.0.1:8080-1) javax.servlet.http.HttpServlet.service(HttpServlet.java:847)
18:30:19,350 INFO  [stdout] (http-/127.0.0.1:8080-1) org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:295)
18:30:19,350 INFO  [stdout] (http-/127.0.0.1:8080-1)   . . .
18:30:19,350 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan org.jboss.as.quickstarts.helloworld.TestBean Serializable KO
18:30:19,350 INFO  [stdout] (http-/127.0.0.1:8080-1) ##ByteMan org.jboss.as.quickstarts.helloworld.TestBean2 Serializable OK
```
