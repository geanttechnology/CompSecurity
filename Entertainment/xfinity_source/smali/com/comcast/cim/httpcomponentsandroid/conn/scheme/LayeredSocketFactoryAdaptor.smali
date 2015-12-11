.class Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSocketFactoryAdaptor;
.super Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;
.source "LayeredSocketFactoryAdaptor.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSocketFactory;


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field private final factory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSchemeSocketFactory;


# direct methods
.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSchemeSocketFactory;)V
    .locals 0
    .param p1, "factory"    # Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSchemeSocketFactory;

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;)V

    .line 41
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSocketFactoryAdaptor;->factory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSchemeSocketFactory;

    .line 42
    return-void
.end method
