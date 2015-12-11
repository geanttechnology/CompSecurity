.class public Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;
.super Ljava/lang/Object;
.source "RetailSearchResultStyles.java"


# static fields
.field private static STYLED_TEXT_STYLES:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field public static STYLE_DATE_BY:Ljava/lang/String;

.field public static STYLE_LINK:Ljava/lang/String;

.field public static STYLE_STRIKETHROUGH:Ljava/lang/String;

.field public static STYLE_TIME_LEFT:Ljava/lang/String;

.field private static styles:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 26
    const-string/jumbo v0, "DATE_BY"

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLE_DATE_BY:Ljava/lang/String;

    .line 27
    const-string/jumbo v0, "TIME_LEFT"

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLE_TIME_LEFT:Ljava/lang/String;

    .line 28
    const-string/jumbo v0, "STRIKETHROUGH"

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLE_STRIKETHROUGH:Ljava/lang/String;

    .line 29
    const-string/jumbo v0, "LINK"

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLE_LINK:Ljava/lang/String;

    .line 34
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLED_TEXT_STYLES:Ljava/util/Map;

    .line 37
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLED_TEXT_STYLES:Ljava/util/Map;

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLE_DATE_BY:Ljava/lang/String;

    sget v2, Lcom/amazon/retailsearch/R$style;->Results_StyledTextSpan_DATE_BY:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLED_TEXT_STYLES:Ljava/util/Map;

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLE_TIME_LEFT:Ljava/lang/String;

    sget v2, Lcom/amazon/retailsearch/R$style;->Results_StyledTextSpan_TIME_LEFT:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 39
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLED_TEXT_STYLES:Ljava/util/Map;

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLE_STRIKETHROUGH:Ljava/lang/String;

    sget v2, Lcom/amazon/retailsearch/R$style;->Results_StyledTextSpan_STRIKETHROUGH:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 40
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLED_TEXT_STYLES:Ljava/util/Map;

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLE_LINK:Ljava/lang/String;

    sget v2, Lcom/amazon/retailsearch/R$style;->Results_StyledTextSpan_LINK:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getStyleId(ILcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/res/Resources;)Ljava/lang/Integer;
    .locals 4
    .param p0, "baseStyleResourceId"    # I
    .param p1, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;
    .param p2, "res"    # Landroid/content/res/Resources;

    .prologue
    .line 86
    sget-object v2, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->styles:Ljava/util/Map;

    if-nez v2, :cond_0

    .line 88
    invoke-static {p2}, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->initStyles(Landroid/content/res/Resources;)V

    .line 90
    :cond_0
    if-eqz p1, :cond_1

    if-nez p2, :cond_2

    .line 92
    :cond_1
    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    .line 100
    .end local p0    # "baseStyleResourceId":I
    :goto_0
    return-object v2

    .line 94
    .restart local p0    # "baseStyleResourceId":I
    :cond_2
    invoke-virtual {p2, p0}, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;

    move-result-object v0

    .line 95
    .local v0, "baseName":Ljava/lang/String;
    if-nez v0, :cond_3

    .line 97
    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    goto :goto_0

    .line 99
    :cond_3
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 100
    .local v1, "childStyle":Ljava/lang/String;
    sget-object v2, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->styles:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_4

    sget-object v2, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->styles:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result p0

    .end local p0    # "baseStyleResourceId":I
    :cond_4
    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    goto :goto_0
.end method

.method public static getStyledTextStyleId(Ljava/lang/String;)Ljava/lang/Integer;
    .locals 1
    .param p0, "styledTextName"    # Ljava/lang/String;

    .prologue
    .line 111
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLED_TEXT_STYLES:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    return-object v0
.end method

.method private static initStyles(Landroid/content/res/Resources;)V
    .locals 10
    .param p0, "res"    # Landroid/content/res/Resources;

    .prologue
    .line 49
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    sput-object v8, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->styles:Ljava/util/Map;

    .line 50
    if-nez p0, :cond_1

    .line 73
    :cond_0
    return-void

    .line 54
    :cond_1
    const-class v0, Lcom/amazon/retailsearch/R$style;

    .line 55
    .local v0, "c":Ljava/lang/Class;, "Ljava/lang/Class<Lcom/amazon/retailsearch/R$style;>;"
    invoke-virtual {v0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v2

    .line 57
    .local v2, "fields":[Ljava/lang/reflect/Field;
    new-instance v7, Lcom/amazon/retailsearch/R$style;

    invoke-direct {v7}, Lcom/amazon/retailsearch/R$style;-><init>()V

    .line 58
    .local v7, "styleResource":Lcom/amazon/retailsearch/R$style;
    const/4 v3, 0x0

    .local v3, "i":I
    array-length v4, v2

    .local v4, "max":I
    :goto_0
    if-ge v3, v4, :cond_0

    .line 64
    :try_start_0
    aget-object v8, v2, v3

    invoke-virtual {v8, v7}, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I

    move-result v5

    .line 65
    .local v5, "resourceId":I
    invoke-virtual {p0, v5}, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 71
    .local v6, "resourceName":Ljava/lang/String;
    sget-object v8, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->styles:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-interface {v8, v6, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    .end local v5    # "resourceId":I
    .end local v6    # "resourceName":Ljava/lang/String;
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 67
    :catch_0
    move-exception v1

    .line 69
    .local v1, "e":Ljava/lang/Exception;
    goto :goto_1
.end method
