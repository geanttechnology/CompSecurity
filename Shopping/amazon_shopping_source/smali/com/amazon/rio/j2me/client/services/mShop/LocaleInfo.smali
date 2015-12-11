.class public Lcom/amazon/rio/j2me/client/services/mShop/LocaleInfo;
.super Ljava/lang/Object;
.source "LocaleInfo.java"


# instance fields
.field private code:Ljava/lang/String;

.field private country:Ljava/lang/String;

.field private language:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setCode(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LocaleInfo;->code:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setCountry(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LocaleInfo;->country:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public setLanguage(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LocaleInfo;->language:Ljava/lang/String;

    .line 41
    return-void
.end method
