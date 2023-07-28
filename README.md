Running `./gradlew site:compileDevelopmentExecutableKotlinJs` fails with
```
e: java.lang.IllegalArgumentException: Cross module dependency resolution failed due to signature 'kotlinx.dom/clear|6741251430650539538[0]' redefinition
        at org.jetbrains.kotlin.ir.backend.js.transformers.irToJs.JsIrModuleCrossModuleReferenceBuilder.buildCrossModuleRefs(JsIrProgramFragment.kt:168)
        at org.jetbrains.kotlin.ir.backend.js.transformers.irToJs.CrossModuleDependenciesResolver.resolveCrossModuleDependencies(JsIrProgramFragment.kt:131)
        at org.jetbrains.kotlin.ir.backend.js.ic.JsExecutableProducer.buildMultiModuleExecutable(JsExecutableProducer.kt:56)
        at org.jetbrains.kotlin.ir.backend.js.ic.JsExecutableProducer.buildExecutable(JsExecutableProducer.kt:30)
        at org.jetbrains.kotlin.cli.js.K2JsIrCompiler.doExecute(K2JsIrCompiler.kt:309)
        at org.jetbrains.kotlin.cli.js.K2JSCompiler.doExecute(K2JSCompiler.java:181)
        at org.jetbrains.kotlin.cli.js.K2JSCompiler.doExecute(K2JSCompiler.java:72)
        at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:100)
        at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:46)
        at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
        at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:1497)
        at jdk.internal.reflect.GeneratedMethodAccessor31.invoke(Unknown Source)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:566)
        at java.rmi/sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:359)
        at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:200)
        at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:197)
        at java.base/java.security.AccessController.doPrivileged(Native Method)
        at java.rmi/sun.rmi.transport.Transport.serviceCall(Transport.java:196)
        at java.rmi/sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:562)
        at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:796)
        at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:677)
        at java.base/java.security.AccessController.doPrivileged(Native Method)
        at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:676)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
        at java.base/java.lang.Thread.run(Thread.java:829)
```

Runs successfully with compose 1.4.1 + kotlin 1.8.20, compose 1.4.3 + kotlin 1.8.22

Fails with compose 1.4.3 + kotlin 1.9.0, compose 1.5.0-beta01 + kotlin 1.9.0

Also runs successfully if `implementation(compose.runtime)` dependency is moved from under `commonMain` to under `jsMain`