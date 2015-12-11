.class Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerAdapter;
.super Landroid/widget/ArrayAdapter;
.source "DebugSettingsView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/debug/DebugSettingsView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LocaleSpinnerAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/debug/DebugSettingsView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/debug/DebugSettingsView;Landroid/content/Context;)V
    .locals 3
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 256
    iput-object p1, p0, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerAdapter;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    .line 257
    const v2, 0x1090008

    invoke-direct {p0, p2, v2}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 258
    const v2, 0x1090009

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerAdapter;->setDropDownViewResource(I)V

    .line 259
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AppLocale;->getSupportedLocaleNameArray()[Ljava/lang/Object;

    move-result-object v1

    .line 260
    .local v1, "localeNameArray":[Ljava/lang/Object;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, v1

    if-ge v0, v2, :cond_0

    .line 261
    aget-object v2, v1, v0

    check-cast v2, Ljava/lang/String;

    check-cast v2, Ljava/lang/String;

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerAdapter;->add(Ljava/lang/Object;)V

    .line 260
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 263
    :cond_0
    return-void
.end method
