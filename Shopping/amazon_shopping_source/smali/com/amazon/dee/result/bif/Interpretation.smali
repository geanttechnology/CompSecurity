.class public Lcom/amazon/dee/result/bif/Interpretation;
.super Ljava/lang/Object;
.source "Interpretation.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private mDomain:Ljava/lang/String;

.field private mIntent:Lcom/amazon/dee/result/bif/Intent;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Intent;)V
    .locals 0
    .param p1, "domain"    # Ljava/lang/String;
    .param p2, "intent"    # Lcom/amazon/dee/result/bif/Intent;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Interpretation;->mDomain:Ljava/lang/String;

    .line 40
    iput-object p2, p0, Lcom/amazon/dee/result/bif/Interpretation;->mIntent:Lcom/amazon/dee/result/bif/Intent;

    .line 41
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 89
    instance-of v2, p1, Lcom/amazon/dee/result/bif/Interpretation;

    if-eqz v2, :cond_0

    move-object v0, p1

    .line 91
    check-cast v0, Lcom/amazon/dee/result/bif/Interpretation;

    .line 92
    .local v0, "other":Lcom/amazon/dee/result/bif/Interpretation;
    iget-object v2, p0, Lcom/amazon/dee/result/bif/Interpretation;->mDomain:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Interpretation;->mDomain:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Interpretation;->mIntent:Lcom/amazon/dee/result/bif/Intent;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Interpretation;->mIntent:Lcom/amazon/dee/result/bif/Intent;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 97
    .end local v0    # "other":Lcom/amazon/dee/result/bif/Interpretation;
    :cond_0
    return v1
.end method

.method public final getDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Interpretation;->mDomain:Ljava/lang/String;

    return-object v0
.end method

.method public final getIntent()Lcom/amazon/dee/result/bif/Intent;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Interpretation;->mIntent:Lcom/amazon/dee/result/bif/Intent;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 104
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Interpretation;->mDomain:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Interpretation;->mIntent:Lcom/amazon/dee/result/bif/Intent;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public final setDomain(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Interpretation;->mDomain:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public final setIntent(Lcom/amazon/dee/result/bif/Intent;)V
    .locals 0
    .param p1, "intent"    # Lcom/amazon/dee/result/bif/Intent;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Interpretation;->mIntent:Lcom/amazon/dee/result/bif/Intent;

    .line 83
    return-void
.end method
