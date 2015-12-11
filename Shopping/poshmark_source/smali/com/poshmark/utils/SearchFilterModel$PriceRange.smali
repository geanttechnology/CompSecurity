.class public Lcom/poshmark/utils/SearchFilterModel$PriceRange;
.super Ljava/lang/Object;
.source "SearchFilterModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/SearchFilterModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "PriceRange"
.end annotation


# instance fields
.field max:Ljava/lang/String;

.field min:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/utils/SearchFilterModel;


# direct methods
.method protected constructor <init>(Lcom/poshmark/utils/SearchFilterModel;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p2, "min"    # Ljava/lang/String;
    .param p3, "max"    # Ljava/lang/String;

    .prologue
    .line 932
    iput-object p1, p0, Lcom/poshmark/utils/SearchFilterModel$PriceRange;->this$0:Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 933
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 934
    iput-object p2, p0, Lcom/poshmark/utils/SearchFilterModel$PriceRange;->min:Ljava/lang/String;

    .line 935
    :cond_0
    if-eqz p3, :cond_1

    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 936
    iput-object p3, p0, Lcom/poshmark/utils/SearchFilterModel$PriceRange;->max:Ljava/lang/String;

    .line 937
    :cond_1
    return-void
.end method


# virtual methods
.method public getDisplay()Ljava/lang/String;
    .locals 3

    .prologue
    .line 940
    const-string v0, ""

    .line 941
    .local v0, "display":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel$PriceRange;->min:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel$PriceRange;->min:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 942
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel$PriceRange;->min:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 944
    :cond_0
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 945
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel$PriceRange;->min:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/utils/SearchFilterModel$PriceRange;->min:Ljava/lang/String;

    .line 947
    :cond_1
    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel$PriceRange;->max:Ljava/lang/String;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/poshmark/utils/SearchFilterModel$PriceRange;->max:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_2

    .line 948
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/SearchFilterModel$PriceRange;->max:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 950
    :cond_2
    return-object v0
.end method
