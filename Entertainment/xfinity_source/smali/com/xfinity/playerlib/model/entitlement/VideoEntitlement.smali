.class public Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
.super Ljava/lang/Object;
.source "VideoEntitlement.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final edata:Ljava/lang/String;

.field private entitlements:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final xedata:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->entitlements:Ljava/util/Set;

    .line 20
    const-string v0, ""

    iput-object v0, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->edata:Ljava/lang/String;

    .line 21
    const-string v0, ""

    iput-object v0, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->xedata:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "eData"    # Ljava/lang/String;
    .param p2, "xeData"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    iput-object v2, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->entitlements:Ljava/util/Set;

    .line 27
    iput-object p1, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->edata:Ljava/lang/String;

    .line 28
    iput-object p2, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->xedata:Ljava/lang/String;

    .line 30
    iget-object v2, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->edata:Ljava/lang/String;

    const-string v4, "&"

    invoke-virtual {v2, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    array-length v5, v4

    move v2, v3

    :goto_0
    if-ge v2, v5, :cond_1

    aget-object v1, v4, v2

    .line 32
    .local v1, "entitlement":Ljava/lang/String;
    const-string v6, "="

    invoke-virtual {v1, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 33
    .local v0, "eDetails":[Ljava/lang/String;
    const-string v6, "y"

    const/4 v7, 0x1

    aget-object v7, v0, v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 34
    iget-object v6, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->entitlements:Ljava/util/Set;

    aget-object v7, v0, v3

    invoke-interface {v6, v7}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 30
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 38
    .end local v0    # "eDetails":[Ljava/lang/String;
    .end local v1    # "entitlement":Ljava/lang/String;
    :cond_1
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "other"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    .line 106
    if-ne p0, p1, :cond_1

    .line 116
    :cond_0
    :goto_0
    return v1

    .line 110
    :cond_1
    instance-of v2, p1, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    if-eqz v2, :cond_2

    move-object v0, p1

    .line 111
    check-cast v0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 112
    .local v0, "otherEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v2, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->edata:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->getEdata()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->xedata:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->getXedata()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 116
    .end local v0    # "otherEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getEdata()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->edata:Ljava/lang/String;

    return-object v0
.end method

.method public getXedata()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->xedata:Ljava/lang/String;

    return-object v0
.end method

.method public isEntitled(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z
    .locals 4
    .param p1, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 90
    const/4 v1, 0x0

    .line 91
    .local v1, "isEntitled":Z
    if-eqz p1, :cond_1

    .line 92
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getProviderCodes()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 93
    .local v0, "aProvider":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Ljava/lang/String;)Z

    move-result v1

    .line 94
    if-eqz v1, :cond_0

    .line 101
    .end local v0    # "aProvider":Ljava/lang/String;
    :cond_1
    return v1
.end method

.method public isEntitled(Ljava/lang/String;)Z
    .locals 2
    .param p1, "providerCode"    # Ljava/lang/String;

    .prologue
    .line 49
    const/4 v0, 0x0

    .line 51
    .local v0, "isEntitled":Z
    if-eqz p1, :cond_0

    .line 52
    const-string v1, "free"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 53
    const/4 v0, 0x1

    .line 59
    :cond_0
    :goto_0
    return v0

    .line 55
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->entitlements:Ljava/util/Set;

    invoke-interface {v1, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public isEntitledToList(Ljava/lang/String;)Z
    .locals 2
    .param p1, "providerCodeList"    # Ljava/lang/String;

    .prologue
    .line 64
    const/4 v0, 0x0

    .line 66
    .local v0, "isEntitled":Z
    if-eqz p1, :cond_0

    .line 67
    const-string v1, ","

    invoke-virtual {p1, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitledToList([Ljava/lang/String;)Z

    move-result v0

    .line 70
    .end local v0    # "isEntitled":Z
    :cond_0
    return v0
.end method

.method public isEntitledToList([Ljava/lang/String;)Z
    .locals 4
    .param p1, "providerCodeList"    # [Ljava/lang/String;

    .prologue
    .line 75
    const/4 v0, 0x0

    .line 77
    .local v0, "isEntitled":Z
    if-eqz p1, :cond_0

    .line 78
    array-length v3, p1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, p1, v2

    .line 79
    .local v1, "pCode":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Ljava/lang/String;)Z

    move-result v0

    .line 80
    if-eqz v0, :cond_1

    .line 86
    .end local v1    # "pCode":Ljava/lang/String;
    :cond_0
    return v0

    .line 78
    .restart local v1    # "pCode":Ljava/lang/String;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 121
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "@"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
