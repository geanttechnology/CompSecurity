.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
.super Ljava/lang/Object;
.source "RoutedRequest.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field protected final request:Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

.field protected final route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)V
    .locals 0
    .param p1, "req"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    .param p2, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->request:Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    .line 54
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    .line 55
    return-void
.end method


# virtual methods
.method public final getRequest()Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->request:Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    return-object v0
.end method

.method public final getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    return-object v0
.end method
