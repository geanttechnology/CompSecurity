.class public Lcom/poshmark/data_model/models/MetaItem;
.super Ljava/lang/Object;
.source "MetaItem.java"


# instance fields
.field private display:Ljava/lang/String;

.field private id:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/data_model/models/MetaItem;->display:Ljava/lang/String;

    .line 14
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/data_model/models/MetaItem;->id:Ljava/lang/String;

    .line 15
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "n"    # Ljava/lang/String;
    .param p2, "d"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-object p1, p0, Lcom/poshmark/data_model/models/MetaItem;->id:Ljava/lang/String;

    .line 39
    iput-object p2, p0, Lcom/poshmark/data_model/models/MetaItem;->display:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public static clone(Lcom/poshmark/data_model/models/MetaItem;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 3
    .param p0, "item"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 63
    if-eqz p0, :cond_0

    .line 64
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 19
    if-ne p0, p1, :cond_1

    .line 27
    :cond_0
    :goto_0
    return v1

    .line 20
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 22
    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 24
    .local v0, "metaItem":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v3, p0, Lcom/poshmark/data_model/models/MetaItem;->display:Ljava/lang/String;

    iget-object v4, v0, Lcom/poshmark/data_model/models/MetaItem;->display:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    move v1, v2

    goto :goto_0

    .line 25
    :cond_4
    iget-object v3, p0, Lcom/poshmark/data_model/models/MetaItem;->id:Ljava/lang/String;

    iget-object v4, v0, Lcom/poshmark/data_model/models/MetaItem;->id:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    goto :goto_0
.end method

.method public getDisplay()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/poshmark/data_model/models/MetaItem;->display:Ljava/lang/String;

    return-object v0
.end method

.method public getFormattedDisplayStringBuilder()Landroid/text/SpannableStringBuilder;
    .locals 6

    .prologue
    const/16 v5, 0xa

    .line 52
    iget-object v3, p0, Lcom/poshmark/data_model/models/MetaItem;->display:Ljava/lang/String;

    const/16 v4, 0x2f

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v0

    .line 53
    .local v0, "d":Ljava/lang/String;
    invoke-virtual {v0, v5}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    .line 54
    .local v1, "r":I
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 55
    .local v2, "ssb":Landroid/text/SpannableStringBuilder;
    if-ltz v1, :cond_0

    .line 56
    new-instance v3, Landroid/text/style/RelativeSizeSpan;

    const v4, 0x3f666666    # 0.9f

    invoke-direct {v3, v4}, Landroid/text/style/RelativeSizeSpan;-><init>(F)V

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    const/16 v5, 0x21

    invoke-virtual {v2, v3, v1, v4, v5}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 58
    :cond_0
    return-object v2
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/poshmark/data_model/models/MetaItem;->id:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 32
    iget-object v1, p0, Lcom/poshmark/data_model/models/MetaItem;->display:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 33
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/poshmark/data_model/models/MetaItem;->id:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 34
    return v0
.end method

.method public setDisplay(Ljava/lang/String;)V
    .locals 0
    .param p1, "d"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/poshmark/data_model/models/MetaItem;->display:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/poshmark/data_model/models/MetaItem;->id:Ljava/lang/String;

    .line 76
    return-void
.end method
