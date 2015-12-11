.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityGrid;
.super Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;
.source "AvailabilityGrid.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 24
    return-void
.end method


# virtual methods
.method protected postInflate()V
    .locals 1

    .prologue
    .line 32
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_availability_low_stock:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityGrid;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityGrid;->lowStock:Landroid/widget/TextView;

    .line 33
    return-void
.end method
