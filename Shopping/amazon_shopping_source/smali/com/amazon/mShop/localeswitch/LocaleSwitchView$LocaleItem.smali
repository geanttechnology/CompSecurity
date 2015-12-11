.class final enum Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;
.super Ljava/lang/Enum;
.source "LocaleSwitchView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/localeswitch/LocaleSwitchView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "LocaleItem"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

.field public static final enum DE_DE:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

.field public static final enum EN_CA:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

.field public static final enum EN_GB:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

.field public static final enum EN_IN:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

.field public static final enum EN_US:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

.field public static final enum ES_ES:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

.field public static final enum FR_CA:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

.field public static final enum FR_FR:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

.field public static final enum IT_IT:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

.field public static final enum JA_JP:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

.field public static final enum ZH_CN:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;


# instance fields
.field private mIconDrawableId:I

.field private mLocaleString:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 10

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 41
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    const-string/jumbo v1, "EN_CA"

    sget v2, Lcom/amazon/mShop/android/lib/R$drawable;->icon_locale_ca:I

    const-string/jumbo v3, "en_CA"

    invoke-direct {v0, v1, v5, v2, v3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->EN_CA:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    .line 42
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    const-string/jumbo v1, "FR_CA"

    sget v2, Lcom/amazon/mShop/android/lib/R$drawable;->icon_locale_ca:I

    const-string/jumbo v3, "fr_CA"

    invoke-direct {v0, v1, v6, v2, v3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->FR_CA:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    .line 43
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    const-string/jumbo v1, "ZH_CN"

    sget v2, Lcom/amazon/mShop/android/lib/R$drawable;->icon_locale_zh:I

    const-string/jumbo v3, "zh_CN"

    invoke-direct {v0, v1, v7, v2, v3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->ZH_CN:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    .line 44
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    const-string/jumbo v1, "DE_DE"

    sget v2, Lcom/amazon/mShop/android/lib/R$drawable;->icon_locale_de:I

    const-string/jumbo v3, "de_DE"

    invoke-direct {v0, v1, v8, v2, v3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->DE_DE:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    .line 45
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    const-string/jumbo v1, "ES_ES"

    sget v2, Lcom/amazon/mShop/android/lib/R$drawable;->icon_locale_es:I

    const-string/jumbo v3, "es_ES"

    invoke-direct {v0, v1, v9, v2, v3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->ES_ES:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    .line 46
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    const-string/jumbo v1, "FR_FR"

    const/4 v2, 0x5

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->icon_locale_fr:I

    const-string/jumbo v4, "fr_FR"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->FR_FR:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    .line 47
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    const-string/jumbo v1, "EN_IN"

    const/4 v2, 0x6

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->icon_locale_in:I

    const-string/jumbo v4, "en_IN"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->EN_IN:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    .line 48
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    const-string/jumbo v1, "IT_IT"

    const/4 v2, 0x7

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->icon_locale_it:I

    const-string/jumbo v4, "it_IT"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->IT_IT:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    .line 49
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    const-string/jumbo v1, "JA_JP"

    const/16 v2, 0x8

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->icon_locale_ja:I

    const-string/jumbo v4, "ja_JP"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->JA_JP:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    .line 50
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    const-string/jumbo v1, "EN_GB"

    const/16 v2, 0x9

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->icon_locale_en_gb:I

    const-string/jumbo v4, "en_GB"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->EN_GB:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    .line 51
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    const-string/jumbo v1, "EN_US"

    const/16 v2, 0xa

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->icon_locale_en_us:I

    const-string/jumbo v4, "en_US"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->EN_US:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    .line 40
    const/16 v0, 0xb

    new-array v0, v0, [Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    sget-object v1, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->EN_CA:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->FR_CA:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->ZH_CN:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->DE_DE:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    aput-object v1, v0, v8

    sget-object v1, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->ES_ES:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    aput-object v1, v0, v9

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->FR_FR:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->EN_IN:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->IT_IT:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->JA_JP:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->EN_GB:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->EN_US:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->$VALUES:[Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IILjava/lang/String;)V
    .locals 0
    .param p3, "iconDrwableId"    # I
    .param p4, "localeString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 56
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 57
    iput p3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->mIconDrawableId:I

    .line 58
    iput-object p4, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->mLocaleString:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 40
    const-class v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;
    .locals 1

    .prologue
    .line 40
    sget-object v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->$VALUES:[Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    invoke-virtual {v0}, [Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    return-object v0
.end method


# virtual methods
.method public getIconDrawableId()I
    .locals 1

    .prologue
    .line 62
    iget v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->mIconDrawableId:I

    return v0
.end method

.method public getLocaleString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->mLocaleString:Ljava/lang/String;

    return-object v0
.end method
