.class public Lcom/poshmark/utils/meta_data/AvailabilityMetaData;
.super Ljava/lang/Object;
.source "AvailabilityMetaData.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/meta_data/AvailabilityMetaData$1;,
        Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;
    }
.end annotation


# static fields
.field public static final ALL_ITEMS:Ljava/lang/String; = "all_items"

.field public static final AVAILABLE:Ljava/lang/String; = "available"

.field public static final NOT_FOR_SALE:Ljava/lang/String; = "not_for_sale"

.field public static final SOLD_OUT:Ljava/lang/String; = "sold_out"


# instance fields
.field availabilityOptions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 5

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;->availabilityOptions:Ljava/util/List;

    .line 25
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;->availabilityOptions:Ljava/util/List;

    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    const-string v2, "all_items"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f060040

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 26
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;->availabilityOptions:Ljava/util/List;

    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    const-string v2, "available"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0602ae

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 27
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;->availabilityOptions:Ljava/util/List;

    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    const-string v2, "sold_out"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f060287

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 28
    return-void
.end method

.method public static getAvailabilityMetaItemFromLabel(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 4
    .param p0, "availString"    # Ljava/lang/String;

    .prologue
    .line 47
    const/4 v0, 0x0

    .line 48
    .local v0, "item":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz p0, :cond_0

    .line 49
    const-string v1, "sold_out"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 50
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "sold_out"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060287

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    :goto_0
    return-object v0

    .line 51
    :cond_1
    const-string v1, "available"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 52
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "available"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f0602ae

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    goto :goto_0

    .line 54
    :cond_2
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const-string v1, "all_items"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060040

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .restart local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    goto :goto_0
.end method


# virtual methods
.method getAvailabilityItem(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 3
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 31
    iget-object v2, p0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;->availabilityOptions:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 32
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 33
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 34
    .local v0, "item":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 39
    .end local v0    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getAvailabilityList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 43
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData;->availabilityOptions:Ljava/util/List;

    return-object v0
.end method

.method public getAvailabilityMetaItem(Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;)Lcom/poshmark/data_model/models/MetaItem;
    .locals 4
    .param p1, "type"    # Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    .prologue
    .line 61
    sget-object v0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$1;->$SwitchMap$com$poshmark$utils$meta_data$AvailabilityMetaData$AVAILABILITY_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 70
    :goto_0
    const/4 v0, 0x0

    :goto_1
    return-object v0

    .line 63
    :pswitch_0
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    const-string v1, "all_items"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060040

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 65
    :pswitch_1
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    const-string v1, "sold_items"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060287

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 67
    :pswitch_2
    new-instance v0, Lcom/poshmark/data_model/models/MetaItem;

    const-string v1, "unsold_items"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f0602ae

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 61
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
