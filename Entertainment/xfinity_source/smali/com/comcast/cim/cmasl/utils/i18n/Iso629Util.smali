.class public Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;
.super Ljava/lang/Object;
.source "Iso629Util.java"


# static fields
.field private static final iso3LocaleMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Locale;",
            ">;"
        }
    .end annotation
.end field

.field private static final localeMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Locale;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    .line 13
    invoke-static {}, Ljava/util/Locale;->getISOLanguages()[Ljava/lang/String;

    move-result-object v4

    .line 15
    .local v4, "supportedLanguages":[Ljava/lang/String;
    new-instance v6, Ljava/util/HashMap;

    array-length v7, v4

    invoke-direct {v6, v7}, Ljava/util/HashMap;-><init>(I)V

    sput-object v6, Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;->localeMap:Ljava/util/Map;

    .line 16
    new-instance v6, Ljava/util/HashMap;

    array-length v7, v4

    invoke-direct {v6, v7}, Ljava/util/HashMap;-><init>(I)V

    sput-object v6, Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;->iso3LocaleMap:Ljava/util/Map;

    .line 17
    move-object v0, v4

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v2, v0, v1

    .line 18
    .local v2, "language":Ljava/lang/String;
    new-instance v5, Ljava/util/Locale;

    invoke-direct {v5, v2}, Ljava/util/Locale;-><init>(Ljava/lang/String;)V

    .line 19
    .local v5, "supportedLocale":Ljava/util/Locale;
    sget-object v6, Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;->localeMap:Ljava/util/Map;

    invoke-interface {v6, v2, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 20
    sget-object v6, Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;->iso3LocaleMap:Ljava/util/Map;

    invoke-virtual {v5}, Ljava/util/Locale;->getISO3Language()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 17
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 22
    .end local v2    # "language":Ljava/lang/String;
    .end local v5    # "supportedLocale":Ljava/util/Locale;
    :cond_0
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getDisplayNameForLanguageCode(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "languageCode"    # Ljava/lang/String;

    .prologue
    .line 29
    invoke-static {p0}, Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;->getLocaleByLanguageCode(Ljava/lang/String;)Ljava/util/Locale;

    move-result-object v0

    .line 30
    .local v0, "locale":Ljava/util/Locale;
    if-eqz v0, :cond_0

    invoke-virtual {v0, v0}, Ljava/util/Locale;->getDisplayLanguage(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static getLocaleByLanguageCode(Ljava/lang/String;)Ljava/util/Locale;
    .locals 2
    .param p0, "languageCode"    # Ljava/lang/String;

    .prologue
    .line 34
    if-nez p0, :cond_0

    .line 35
    const/4 v0, 0x0

    .line 39
    :goto_0
    return-object v0

    .line 36
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 37
    sget-object v0, Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;->localeMap:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Locale;

    goto :goto_0

    .line 39
    :cond_1
    sget-object v0, Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;->iso3LocaleMap:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Locale;

    goto :goto_0
.end method
