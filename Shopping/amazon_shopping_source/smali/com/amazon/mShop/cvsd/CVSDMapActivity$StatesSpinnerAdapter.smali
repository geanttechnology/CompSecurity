.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;
.super Landroid/widget/ArrayAdapter;
.source "CVSDMapActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "StatesSpinnerAdapter"
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
.field final states:[Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/content/Context;)V
    .locals 6
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 884
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .line 885
    const v4, 0x1090008

    invoke-direct {p0, p2, v4}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 886
    const v4, 0x1090009

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;->setDropDownViewResource(I)V

    .line 888
    invoke-virtual {p1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$array;->opl_new_address_jp_states:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;->states:[Ljava/lang/String;

    .line 890
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;->states:[Ljava/lang/String;

    .local v0, "arr$":[Ljava/lang/String;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 891
    .local v3, "s":Ljava/lang/String;
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;->add(Ljava/lang/Object;)V

    .line 890
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 893
    .end local v3    # "s":Ljava/lang/String;
    :cond_0
    return-void
.end method
