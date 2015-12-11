.class public Ltv/freewheel/ad/Visitor;
.super Ljava/lang/Object;
.source "Visitor.java"


# instance fields
.field public bandwidth:I

.field public bandwidthSource:Ljava/lang/String;

.field public caller:Ljava/lang/String;

.field public customId:Ljava/lang/String;

.field public httpHeaders:Ljava/util/TreeMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public ipV4Address:Ljava/lang/String;

.field protected logger:Ltv/freewheel/utils/Logger;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/Visitor;->logger:Ltv/freewheel/utils/Logger;

    .line 23
    new-instance v0, Ljava/util/TreeMap;

    invoke-direct {v0}, Ljava/util/TreeMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/Visitor;->httpHeaders:Ljava/util/TreeMap;

    .line 24
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "android-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/Visitor;->caller:Ljava/lang/String;

    .line 25
    return-void
.end method

.method private buildBandwidthInfoElement()Ltv/freewheel/utils/XMLElement;
    .locals 3

    .prologue
    .line 70
    new-instance v0, Ltv/freewheel/utils/XMLElement;

    const-string v1, "bandwidthInfo"

    invoke-direct {v0, v1}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 71
    .local v0, "bandwidthInfo":Ltv/freewheel/utils/XMLElement;
    const-string v1, "bandwidth"

    iget v2, p0, Ltv/freewheel/ad/Visitor;->bandwidth:I

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;I)V

    .line 72
    const-string v1, "source"

    iget-object v2, p0, Ltv/freewheel/ad/Visitor;->bandwidthSource:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    return-object v0
.end method

.method private buildHttpHeadersElement()Ltv/freewheel/utils/XMLElement;
    .locals 6

    .prologue
    .line 56
    new-instance v0, Ltv/freewheel/utils/XMLElement;

    const-string v4, "httpHeaders"

    invoke-direct {v0, v4}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 57
    .local v0, "headers":Ltv/freewheel/utils/XMLElement;
    iget-object v4, p0, Ltv/freewheel/ad/Visitor;->httpHeaders:Ljava/util/TreeMap;

    invoke-virtual {v4}, Ljava/util/TreeMap;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 58
    .local v2, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 59
    new-instance v1, Ltv/freewheel/utils/XMLElement;

    const-string v4, "httpHeader"

    invoke-direct {v1, v4}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 60
    .local v1, "httpheader":Ltv/freewheel/utils/XMLElement;
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 61
    .local v3, "key":Ljava/lang/String;
    const-string v4, "name"

    invoke-virtual {v1, v4, v3}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    const-string v5, "value"

    iget-object v4, p0, Ltv/freewheel/ad/Visitor;->httpHeaders:Ljava/util/TreeMap;

    invoke-virtual {v4, v3}, Ljava/util/TreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v1, v5, v4}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    invoke-virtual {v0, v1}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    goto :goto_0

    .line 66
    .end local v1    # "httpheader":Ltv/freewheel/utils/XMLElement;
    .end local v3    # "key":Ljava/lang/String;
    :cond_0
    return-object v0
.end method


# virtual methods
.method public buildXMLElement()Ltv/freewheel/utils/XMLElement;
    .locals 3

    .prologue
    .line 39
    new-instance v0, Ltv/freewheel/utils/XMLElement;

    const-string v1, "visitor"

    invoke-direct {v0, v1}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 40
    .local v0, "visitor":Ltv/freewheel/utils/XMLElement;
    const-string v1, "customId"

    iget-object v2, p0, Ltv/freewheel/ad/Visitor;->customId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    const-string v1, "caller"

    iget-object v2, p0, Ltv/freewheel/ad/Visitor;->caller:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    const-string v1, "ipV4Address"

    iget-object v2, p0, Ltv/freewheel/ad/Visitor;->ipV4Address:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    iget-object v1, p0, Ltv/freewheel/ad/Visitor;->httpHeaders:Ljava/util/TreeMap;

    invoke-virtual {v1}, Ljava/util/TreeMap;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 45
    invoke-direct {p0}, Ltv/freewheel/ad/Visitor;->buildHttpHeadersElement()Ltv/freewheel/utils/XMLElement;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 48
    :cond_0
    iget v1, p0, Ltv/freewheel/ad/Visitor;->bandwidth:I

    if-lez v1, :cond_1

    .line 49
    invoke-direct {p0}, Ltv/freewheel/ad/Visitor;->buildBandwidthInfoElement()Ltv/freewheel/utils/XMLElement;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 52
    :cond_1
    return-object v0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 0
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 84
    return-void
.end method
