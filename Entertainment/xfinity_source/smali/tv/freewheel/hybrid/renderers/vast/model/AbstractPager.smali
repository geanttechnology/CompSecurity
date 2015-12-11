.class abstract Ltv/freewheel/hybrid/renderers/vast/model/AbstractPager;
.super Ljava/lang/Object;
.source "AbstractPager.java"


# instance fields
.field public id:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public isValid()Z
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractPager;->url:Ljava/lang/String;

    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/vast/model/Util;->isNullOrEmptyString(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractPager;->url:Ljava/lang/String;

    invoke-static {v0}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 1
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 19
    const-string v0, "id"

    invoke-interface {p1, v0}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractPager;->id:Ljava/lang/String;

    .line 20
    invoke-static {p1}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractPager;->url:Ljava/lang/String;

    .line 21
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 15
    const-string v0, "[id=%s url=%s]"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractPager;->id:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractPager;->url:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
