.class public Lcom/amazon/ansel/fetch/tools/web/apache/apache40/CustomHttpMethod;
.super Lorg/apache/http/client/methods/HttpEntityEnclosingRequestBase;
.source "CustomHttpMethod.java"


# instance fields
.field private final method:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/String;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0}, Lorg/apache/http/client/methods/HttpEntityEnclosingRequestBase;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/CustomHttpMethod;->method:Ljava/lang/String;

    .line 23
    invoke-static {p2}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/CustomHttpMethod;->setURI(Ljava/net/URI;)V

    .line 24
    return-void
.end method


# virtual methods
.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/CustomHttpMethod;->method:Ljava/lang/String;

    return-object v0
.end method
