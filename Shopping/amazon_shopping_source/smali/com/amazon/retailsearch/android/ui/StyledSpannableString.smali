.class public Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
.super Landroid/text/SpannableStringBuilder;
.source "StyledSpannableString.java"


# static fields
.field private static final RUPEE_CHAR:C = '\u20b9'

.field private static final STYLED_TEXT_STYLE_ASSET:Ljava/lang/String; = "ASSET_ID_BADGE"

.field private static rupeeFont:Landroid/graphics/Typeface;


# instance fields
.field private final context:Landroid/content/Context;

.field retailSearchDataProvider:Ldagger/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private final viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 65
    invoke-direct {p0}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 56
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 66
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 67
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 68
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->context:Landroid/content/Context;

    .line 69
    return-void
.end method

.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V
    .locals 1
    .param p1, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 80
    invoke-direct {p0}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 56
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 81
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 82
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 83
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->context:Landroid/content/Context;

    .line 84
    return-void
.end method

.method private fixRupeeCharacter(I)V
    .locals 6
    .param p1, "startPos"    # I

    .prologue
    .line 322
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0xb

    if-ge v4, v5, :cond_0

    const-string/jumbo v4, "en_IN"

    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getLocale()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 348
    :cond_0
    :goto_0
    return-void

    .line 327
    :cond_1
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->loadRupeeFont()V

    .line 328
    sget-object v4, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->rupeeFont:Landroid/graphics/Typeface;

    if-eqz v4, :cond_0

    .line 334
    move v3, p1

    .local v3, "i":I
    :goto_1
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v4

    if-ge v3, v4, :cond_0

    .line 336
    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->charAt(I)C

    move-result v0

    .line 337
    .local v0, "c":C
    const/16 v4, 0x20b9

    if-ne v0, v4, :cond_2

    .line 339
    new-instance v1, Lcom/amazon/retailsearch/android/ui/CustomTypefaceSpan;

    sget-object v4, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->rupeeFont:Landroid/graphics/Typeface;

    invoke-direct {v1, v4}, Lcom/amazon/retailsearch/android/ui/CustomTypefaceSpan;-><init>(Landroid/graphics/Typeface;)V

    .line 340
    .local v1, "characterImage":Lcom/amazon/retailsearch/android/ui/CustomTypefaceSpan;
    add-int/lit8 v4, v3, 0x1

    const/16 v5, 0x21

    invoke-virtual {p0, v1, v3, v4, v5}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->setSpan(Ljava/lang/Object;III)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 334
    .end local v1    # "characterImage":Lcom/amazon/retailsearch/android/ui/CustomTypefaceSpan;
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 344
    .end local v0    # "c":C
    :catch_0
    move-exception v2

    .line 346
    .local v2, "e":Ljava/lang/Exception;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    const-string/jumbo v5, "fixRupeeCharacter failed"

    invoke-interface {v4, v5, v2}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private loadRupeeFont()V
    .locals 3

    .prologue
    .line 356
    sget-object v1, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->rupeeFont:Landroid/graphics/Typeface;

    if-eqz v1, :cond_0

    .line 369
    :goto_0
    return-void

    .line 363
    :cond_0
    :try_start_0
    sget v1, Lcom/amazon/retailsearch/R$raw;->rupee_char:I

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->context:Landroid/content/Context;

    invoke-static {v1, v2}, Lcom/amazon/retailsearch/android/util/ResUtils;->loadFontFromRes(ILandroid/content/Context;)Landroid/graphics/Typeface;

    move-result-object v1

    sput-object v1, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->rupeeFont:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 365
    :catch_0
    move-exception v0

    .line 367
    .local v0, "e":Ljava/lang/Exception;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    const-string/jumbo v2, "Failed to load the Rupee font"

    invoke-interface {v1, v2, v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private postAppendStyle(IILjava/lang/String;)V
    .locals 7
    .param p1, "styleLength"    # I
    .param p2, "baseStyleId"    # I
    .param p3, "url"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x1

    const/16 v5, 0x21

    .line 385
    if-lez p1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v2

    if-ge v2, p1, :cond_1

    .line 439
    :cond_0
    :goto_0
    return-void

    .line 394
    :cond_1
    new-instance v1, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->context:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;-><init>(Landroid/content/Context;)V

    .line 395
    .local v1, "styleReader":Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v1, p2, v2}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->readStyle(ILcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 397
    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getTextColor()Ljava/lang/Integer;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 399
    new-instance v2, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getTextColor()Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-direct {v2, v3}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v3

    sub-int/2addr v3, p1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v4

    invoke-virtual {p0, v2, v3, v4, v5}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 404
    :cond_2
    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getTextSizePixels()Ljava/lang/Integer;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 406
    new-instance v2, Landroid/text/style/AbsoluteSizeSpan;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getTextSizePixels()Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-direct {v2, v3}, Landroid/text/style/AbsoluteSizeSpan;-><init>(I)V

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v3

    sub-int/2addr v3, p1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v4

    invoke-virtual {p0, v2, v3, v4, v5}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 411
    :cond_3
    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getIsStrikethrough()Ljava/lang/Boolean;

    move-result-object v2

    if-eqz v2, :cond_4

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getIsStrikethrough()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-ne v2, v6, :cond_4

    .line 413
    new-instance v2, Landroid/text/style/StrikethroughSpan;

    invoke-direct {v2}, Landroid/text/style/StrikethroughSpan;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v3

    sub-int/2addr v3, p1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v4

    invoke-virtual {p0, v2, v3, v4, v5}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 417
    :cond_4
    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getIsBold()Ljava/lang/Boolean;

    move-result-object v2

    if-eqz v2, :cond_5

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getIsBold()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-ne v2, v6, :cond_5

    .line 419
    new-instance v2, Landroid/text/style/StyleSpan;

    invoke-direct {v2, v6}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v3

    sub-int/2addr v3, p1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v4

    invoke-virtual {p0, v2, v3, v4, v5}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 423
    :cond_5
    if-eqz p3, :cond_0

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getIsLink()Ljava/lang/Boolean;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getIsLink()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-ne v2, v6, :cond_0

    .line 425
    new-instance v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString$1;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v0, p0, v2, p3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString$1;-><init>(Lcom/amazon/retailsearch/android/ui/StyledSpannableString;Landroid/content/res/Resources;Ljava/lang/String;)V

    .line 436
    .local v0, "clickSpan":Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v2

    sub-int/2addr v2, p1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v3

    invoke-virtual {p0, v0, v2, v3, v5}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_0
.end method


# virtual methods
.method public bridge synthetic append(Ljava/lang/CharSequence;)Landroid/text/Editable;
    .locals 1
    .param p1, "x0"    # Ljava/lang/CharSequence;

    .prologue
    .line 49
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    .locals 1
    .param p1, "x0"    # Ljava/lang/CharSequence;

    .prologue
    .line 49
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    move-result-object v0

    return-object v0
.end method

.method public append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    .locals 2
    .param p1, "text"    # Ljava/lang/CharSequence;

    .prologue
    .line 92
    invoke-super {p0, p1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 94
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    sub-int/2addr v0, v1

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->fixRupeeCharacter(I)V

    .line 95
    return-object p0
.end method

.method public bridge synthetic append(Ljava/lang/CharSequence;)Ljava/lang/Appendable;
    .locals 1
    .param p1, "x0"    # Ljava/lang/CharSequence;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 49
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    move-result-object v0

    return-object v0
.end method

.method public append(Lcom/amazon/searchapp/retailsearch/model/StyledText;I)V
    .locals 8
    .param p1, "styledText"    # Lcom/amazon/searchapp/retailsearch/model/StyledText;
    .param p2, "baseStyleId"    # I

    .prologue
    .line 149
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 179
    :cond_0
    :goto_0
    return-void

    .line 153
    :cond_1
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getText()Ljava/lang/String;

    move-result-object v2

    .line 155
    .local v2, "str":Ljava/lang/String;
    const-string/jumbo v5, "ASSET_ID_BADGE"

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getStyle()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 157
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->retailSearchDataProvider:Ldagger/Lazy;

    invoke-interface {v5}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;

    invoke-interface {v5, v2}, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;->getBadge(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 158
    .local v1, "badgeBitmap":Landroid/graphics/Bitmap;
    if-eqz v1, :cond_0

    .line 160
    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->context:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-direct {v0, v5, v1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .line 161
    .local v0, "badge":Landroid/graphics/drawable/Drawable;
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {p0, v0, v2, v5}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->appendImage(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/Integer;)V

    goto :goto_0

    .line 167
    .end local v0    # "badge":Landroid/graphics/drawable/Drawable;
    .end local v1    # "badgeBitmap":Landroid/graphics/Bitmap;
    :cond_2
    invoke-virtual {p0, v2, p2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 170
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getStyle()Ljava/lang/String;

    move-result-object v4

    .line 172
    .local v4, "styledTextName":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->getStyledTextStyleId(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    .line 173
    .local v3, "styledTextBaseStyleId":Ljava/lang/Integer;
    if-eqz v3, :cond_0

    .line 176
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v6

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getUrl()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v5, v6, v7}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->postAppendStyle(IILjava/lang/String;)V

    goto :goto_0
.end method

.method public append(Ljava/lang/String;I)V
    .locals 2
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "baseStyleId"    # I

    .prologue
    .line 109
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    .line 112
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, p2, v1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->postAppendStyle(IILjava/lang/String;)V

    .line 113
    return-void
.end method

.method public append(Ljava/util/List;I)V
    .locals 3
    .param p2, "baseStyleId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 127
    .local p1, "styledTextItems":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    if-nez p1, :cond_1

    .line 135
    :cond_0
    return-void

    .line 131
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/StyledText;

    .line 133
    .local v1, "styledText":Lcom/amazon/searchapp/retailsearch/model/StyledText;
    invoke-virtual {p0, v1, p2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Lcom/amazon/searchapp/retailsearch/model/StyledText;I)V

    goto :goto_0
.end method

.method public appendBadge(Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 8
    .param p1, "srdsBadgeId"    # Ljava/lang/String;
    .param p2, "baseStyleId"    # Ljava/lang/Integer;

    .prologue
    .line 194
    :try_start_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 223
    :cond_0
    :goto_0
    return-void

    .line 199
    :cond_1
    const-string/jumbo v2, ""

    .line 201
    .local v2, "badgeDescription":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/retailsearch/data/BadgeType;->getBadgeType(Ljava/lang/String;)Lcom/amazon/retailsearch/data/BadgeType;

    move-result-object v3

    .line 202
    .local v3, "badgeType":Lcom/amazon/retailsearch/data/BadgeType;
    if-eqz v3, :cond_2

    invoke-virtual {v3}, Lcom/amazon/retailsearch/data/BadgeType;->getDescriptionResource()Ljava/lang/Integer;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 205
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->context:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v3}, Lcom/amazon/retailsearch/data/BadgeType;->getDescriptionResource()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 209
    :cond_2
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_3

    const-string/jumbo v2, " "

    .line 211
    :cond_3
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->retailSearchDataProvider:Ldagger/Lazy;

    invoke-interface {v5}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;

    invoke-interface {v5, p1}, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;->getBadge(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 212
    .local v1, "badgeBitmap":Landroid/graphics/Bitmap;
    if-eqz v1, :cond_0

    .line 216
    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->context:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-direct {v0, v5, v1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .line 217
    .local v0, "badge":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p0, v0, v2, p2, p1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->appendImage(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 219
    .end local v0    # "badge":Landroid/graphics/drawable/Drawable;
    .end local v1    # "badgeBitmap":Landroid/graphics/Bitmap;
    .end local v2    # "badgeDescription":Ljava/lang/String;
    .end local v3    # "badgeType":Lcom/amazon/retailsearch/data/BadgeType;
    :catch_0
    move-exception v4

    .line 221
    .local v4, "e":Ljava/lang/Exception;
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "Failed to appendBadge with srdsBadgeId: \'"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "\'"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6, v4}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public appendImage(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 1
    .param p1, "image"    # Landroid/graphics/drawable/Drawable;
    .param p2, "imageDescription"    # Ljava/lang/String;
    .param p3, "baseStyleId"    # Ljava/lang/Integer;

    .prologue
    .line 243
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->appendImage(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V

    .line 244
    return-void
.end method

.method public appendImage(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V
    .locals 14
    .param p1, "image"    # Landroid/graphics/drawable/Drawable;
    .param p2, "imageDescription"    # Ljava/lang/String;
    .param p3, "baseStyleId"    # Ljava/lang/Integer;
    .param p4, "badgeID"    # Ljava/lang/String;

    .prologue
    .line 267
    if-eqz p1, :cond_0

    invoke-static/range {p2 .. p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-eqz v11, :cond_1

    .line 311
    :cond_0
    :goto_0
    return-void

    .line 273
    :cond_1
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v11

    int-to-float v8, v11

    .line 274
    .local v8, "originalImageWidth":F
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v11

    int-to-float v7, v11

    .line 277
    .local v7, "originalImageHeight":F
    float-to-int v4, v8

    .line 278
    .local v4, "imageWidth":I
    float-to-int v3, v7

    .line 279
    .local v3, "imageHeight":I
    const/4 v2, 0x0

    .line 282
    .local v2, "imageAlign":I
    if-eqz p3, :cond_4

    .line 285
    new-instance v10, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;

    iget-object v11, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->context:Landroid/content/Context;

    invoke-direct {v10, v11}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;-><init>(Landroid/content/Context;)V

    .line 286
    .local v10, "styleReader":Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Integer;->intValue()I

    move-result v11

    iget-object v12, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v10, v11, v12}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->readStyle(ILcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 287
    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getImageHeight()Ljava/lang/Float;

    move-result-object v11

    if-nez v11, :cond_2

    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getTextSize()Ljava/lang/Float;

    move-result-object v11

    if-eqz v11, :cond_3

    .line 290
    :cond_2
    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getImageHeight()Ljava/lang/Float;

    move-result-object v11

    if-eqz v11, :cond_5

    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getImageHeight()Ljava/lang/Float;

    move-result-object v11

    :goto_1
    invoke-virtual {v11}, Ljava/lang/Float;->floatValue()F

    move-result v5

    .line 293
    .local v5, "newImageHeight":F
    mul-float v11, v8, v5

    div-float v6, v11, v7

    .line 294
    .local v6, "newImageWidth":F
    float-to-int v4, v6

    .line 295
    float-to-int v3, v5

    .line 297
    .end local v5    # "newImageHeight":F
    .end local v6    # "newImageWidth":F
    :cond_3
    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getImageAlign()Ljava/lang/Integer;

    move-result-object v11

    if-eqz v11, :cond_4

    .line 299
    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getImageAlign()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 304
    .end local v10    # "styleReader":Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;
    :cond_4
    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-virtual {p1, v11, v12, v4, v3}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 307
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->length()I

    move-result v9

    .line 308
    .local v9, "startPosition":I
    move-object/from16 v0, p2

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    .line 309
    new-instance v11, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;

    move-object/from16 v0, p3

    move-object/from16 v1, p4

    invoke-direct {v11, p1, v2, v0, v1}, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;-><init>(Landroid/graphics/drawable/Drawable;ILjava/lang/Integer;Ljava/lang/String;)V

    invoke-virtual/range {p2 .. p2}, Ljava/lang/String;->length()I

    move-result v12

    add-int/2addr v12, v9

    const/16 v13, 0x21

    invoke-virtual {p0, v11, v9, v12, v13}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_0

    .line 290
    .end local v9    # "startPosition":I
    .restart local v10    # "styleReader":Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;
    :cond_5
    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->getTextSize()Ljava/lang/Float;

    move-result-object v11

    goto :goto_1
.end method
