.class public Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestHandlerRegistry;
.super Ljava/lang/Object;
.source "HttpRequestHandlerRegistry.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestHandlerResolver;


# instance fields
.field private final matcher:Lcom/comcast/cim/httpcomponentsandroid/protocol/UriPatternMatcher;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/UriPatternMatcher;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/UriPatternMatcher;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestHandlerRegistry;->matcher:Lcom/comcast/cim/httpcomponentsandroid/protocol/UriPatternMatcher;

    .line 55
    return-void
.end method


# virtual methods
.method public setHandlers(Ljava/util/Map;)V
    .locals 1
    .param p1, "map"    # Ljava/util/Map;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestHandlerRegistry;->matcher:Lcom/comcast/cim/httpcomponentsandroid/protocol/UriPatternMatcher;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/UriPatternMatcher;->setObjects(Ljava/util/Map;)V

    .line 89
    return-void
.end method
