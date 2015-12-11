.class public final synthetic Lcom/appdynamics/eumagent/runtime/InfoPointRegister;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation build Lcom/appdynamics/eumagent/runtime/DontObfuscate;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "Instantiating com.appdynamics.eumagent.runtime.InfoPointRegister"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    return-void
.end method
