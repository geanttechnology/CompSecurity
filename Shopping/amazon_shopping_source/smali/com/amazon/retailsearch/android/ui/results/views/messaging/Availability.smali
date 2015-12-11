.class public abstract Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;
.super Landroid/widget/LinearLayout;
.source "Availability.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;",
        ">;"
    }
.end annotation


# instance fields
.field protected generalAvailability:Landroid/widget/TextView;

.field protected lowStock:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 38
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 39
    return-void
.end method

.method private setMessage(Landroid/widget/TextView;Ljava/lang/String;)Z
    .locals 2
    .param p1, "view"    # Landroid/widget/TextView;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 94
    if-nez p1, :cond_0

    .line 105
    :goto_0
    return v0

    .line 98
    :cond_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 100
    const/16 v1, 0x8

    invoke-virtual {p1, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 103
    :cond_1
    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 104
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 105
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 6
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    const/16 v5, 0x8

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 64
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 66
    :cond_0
    invoke-virtual {p0, v5}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->setVisibility(I)V

    .line 83
    :goto_0
    return-void

    .line 70
    :cond_1
    const/4 v0, 0x0

    .line 71
    .local v0, "numMessagesShown":I
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->generalAvailability:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->getGeneralMessage()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v1, v4}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->setMessage(Landroid/widget/TextView;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    move v1, v2

    :goto_1
    add-int/2addr v0, v1

    .line 72
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->lowStock:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->getLowStockMessage()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v1, v4}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->setMessage(Landroid/widget/TextView;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    :goto_2
    add-int/2addr v0, v2

    .line 75
    if-nez v0, :cond_4

    .line 77
    invoke-virtual {p0, v5}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->setVisibility(I)V

    goto :goto_0

    :cond_2
    move v1, v3

    .line 71
    goto :goto_1

    :cond_3
    move v2, v3

    .line 72
    goto :goto_2

    .line 81
    :cond_4
    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 22
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method

.method protected onFinishInflate()V
    .locals 0

    .prologue
    .line 48
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 49
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->postInflate()V

    .line 50
    return-void
.end method

.method protected abstract postInflate()V
.end method
