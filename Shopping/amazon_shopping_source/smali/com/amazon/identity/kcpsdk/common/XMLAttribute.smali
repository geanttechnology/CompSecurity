.class public Lcom/amazon/identity/kcpsdk/common/XMLAttribute;
.super Lcom/amazon/identity/kcpsdk/common/XMLEntity;
.source "XMLAttribute.java"


# instance fields
.field private final mKey:Ljava/lang/String;

.field private final mValue:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/common/XMLEntity;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/XMLAttribute;->mKey:Ljava/lang/String;

    .line 15
    iput-object p2, p0, Lcom/amazon/identity/kcpsdk/common/XMLAttribute;->mValue:Ljava/lang/String;

    .line 16
    return-void
.end method


# virtual methods
.method toXML(Lorg/w3c/dom/Element;)V
    .locals 2
    .param p1, "ele"    # Lorg/w3c/dom/Element;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/XMLAttribute;->mKey:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/XMLAttribute;->mValue:Ljava/lang/String;

    invoke-interface {p1, v0, v1}, Lorg/w3c/dom/Element;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 22
    return-void
.end method
