.class public Lcom/amazon/identity/kcpsdk/common/XMLCData;
.super Lcom/amazon/identity/kcpsdk/common/XMLEntity;
.source "XMLCData.java"


# instance fields
.field private final mCData:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "cData"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/common/XMLEntity;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/XMLCData;->mCData:Ljava/lang/String;

    .line 16
    return-void
.end method


# virtual methods
.method toXML(Lorg/w3c/dom/Element;)V
    .locals 3
    .param p1, "ele"    # Lorg/w3c/dom/Element;

    .prologue
    .line 21
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getOwnerDocument()Lorg/w3c/dom/Document;

    move-result-object v1

    .line 22
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/XMLCData;->mCData:Ljava/lang/String;

    invoke-interface {v1, v2}, Lorg/w3c/dom/Document;->createCDATASection(Ljava/lang/String;)Lorg/w3c/dom/CDATASection;

    move-result-object v0

    .line 23
    .local v0, "cdata":Lorg/w3c/dom/CDATASection;
    invoke-interface {p1, v0}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 24
    return-void
.end method
