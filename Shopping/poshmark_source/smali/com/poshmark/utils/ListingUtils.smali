.class public Lcom/poshmark/utils/ListingUtils;
.super Ljava/lang/Object;
.source "ListingUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getDrawableIconForCategory(Ljava/lang/String;)I
    .locals 2
    .param p0, "category"    # Ljava/lang/String;

    .prologue
    const v0, 0x7f0200de

    .line 14
    if-nez p0, :cond_1

    .line 61
    :cond_0
    :goto_0
    return v0

    .line 18
    :cond_1
    sget-object v1, Lcom/poshmark/data_model/models/StaticCategoryLookup;->ACCESSORIES_ID:Ljava/lang/String;

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 19
    const v0, 0x7f0200d9

    goto :goto_0

    .line 21
    :cond_2
    sget-object v1, Lcom/poshmark/data_model/models/StaticCategoryLookup;->SHOES_ID:Ljava/lang/String;

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 22
    const v0, 0x7f0200e9

    goto :goto_0

    .line 24
    :cond_3
    sget-object v1, Lcom/poshmark/data_model/models/StaticCategoryLookup;->BAGS_ID:Ljava/lang/String;

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 25
    const v0, 0x7f0200da

    goto :goto_0

    .line 27
    :cond_4
    sget-object v1, Lcom/poshmark/data_model/models/StaticCategoryLookup;->JEANS_ID:Ljava/lang/String;

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 28
    const v0, 0x7f0200e2

    goto :goto_0

    .line 30
    :cond_5
    sget-object v1, Lcom/poshmark/data_model/models/StaticCategoryLookup;->DRESSES_ID:Ljava/lang/String;

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 33
    sget-object v0, Lcom/poshmark/data_model/models/StaticCategoryLookup;->JACKETS_COATS_ID:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 34
    const v0, 0x7f0200e1

    goto :goto_0

    .line 36
    :cond_6
    sget-object v0, Lcom/poshmark/data_model/models/StaticCategoryLookup;->JEWELRY_ID:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 37
    const v0, 0x7f0200e3

    goto :goto_0

    .line 39
    :cond_7
    sget-object v0, Lcom/poshmark/data_model/models/StaticCategoryLookup;->PANTS_ID:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 40
    const v0, 0x7f0200e7

    goto :goto_0

    .line 42
    :cond_8
    sget-object v0, Lcom/poshmark/data_model/models/StaticCategoryLookup;->MAKEUP_ID:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 43
    const v0, 0x7f0200e5

    goto :goto_0

    .line 45
    :cond_9
    sget-object v0, Lcom/poshmark/data_model/models/StaticCategoryLookup;->SKIRTS_ID:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 46
    const v0, 0x7f0200ea

    goto :goto_0

    .line 48
    :cond_a
    sget-object v0, Lcom/poshmark/data_model/models/StaticCategoryLookup;->TOPS_ID:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 49
    const v0, 0x7f0200ee

    goto :goto_0

    .line 51
    :cond_b
    sget-object v0, Lcom/poshmark/data_model/models/StaticCategoryLookup;->SWIM_ID:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 52
    const v0, 0x7f0200ed

    goto/16 :goto_0

    .line 54
    :cond_c
    sget-object v0, Lcom/poshmark/data_model/models/StaticCategoryLookup;->SWEATERS_ID:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 55
    const v0, 0x7f0200ec

    goto/16 :goto_0

    .line 57
    :cond_d
    sget-object v0, Lcom/poshmark/data_model/models/StaticCategoryLookup;->SLEEPWEAR_ID:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 58
    const v0, 0x7f0200eb

    goto/16 :goto_0

    .line 61
    :cond_e
    const v0, 0x7f0200db

    goto/16 :goto_0
.end method
