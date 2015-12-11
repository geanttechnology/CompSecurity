.class final Lcom/localytics/android/TestModeListView$CancelItemAdapter;
.super Landroid/widget/BaseAdapter;
.source "SourceFile"


# instance fields
.field private final MENU_ITEMS:[Ljava/lang/String;

.field private final mContext:Landroid/content/Context;

.field final synthetic this$0:Lcom/localytics/android/TestModeListView;


# direct methods
.method constructor <init>(Lcom/localytics/android/TestModeListView;Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 698
    iput-object p1, p0, Lcom/localytics/android/TestModeListView$CancelItemAdapter;->this$0:Lcom/localytics/android/TestModeListView;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 693
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "Cancel"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/localytics/android/TestModeListView$CancelItemAdapter;->MENU_ITEMS:[Ljava/lang/String;

    .line 699
    iput-object p2, p0, Lcom/localytics/android/TestModeListView$CancelItemAdapter;->mContext:Landroid/content/Context;

    .line 700
    return-void
.end method


# virtual methods
.method public final getCount()I
    .locals 1

    .prologue
    .line 705
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$CancelItemAdapter;->MENU_ITEMS:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public final bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 691
    invoke-virtual {p0, p1}, Lcom/localytics/android/TestModeListView$CancelItemAdapter;->getItem(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getItem(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 711
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$CancelItemAdapter;->MENU_ITEMS:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public final getItemId(I)J
    .locals 2

    .prologue
    .line 717
    int-to-long v0, p1

    return-wide v0
.end method

.method public final getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    const/16 v2, 0xff

    const/4 v7, 0x3

    const/4 v6, -0x1

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 724
    .line 726
    if-nez p2, :cond_0

    .line 728
    new-instance p2, Landroid/widget/LinearLayout;

    iget-object v0, p0, Lcom/localytics/android/TestModeListView$CancelItemAdapter;->mContext:Landroid/content/Context;

    invoke-direct {p2, v0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 729
    new-instance v0, Landroid/widget/AbsListView$LayoutParams;

    const/4 v1, -0x2

    invoke-direct {v0, v6, v1}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    invoke-virtual {p2, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 730
    invoke-virtual {p2, v5}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 731
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$CancelItemAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    const/high16 v1, 0x40c00000    # 6.0f

    mul-float/2addr v0, v1

    const/high16 v1, 0x3f000000    # 0.5f

    add-float/2addr v0, v1

    float-to-int v0, v0

    .line 732
    invoke-virtual {p2, v4, v0, v4, v0}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 735
    new-instance v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/localytics/android/TestModeListView$CancelItemAdapter;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 736
    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setId(I)V

    .line 737
    const/high16 v1, 0x41d00000    # 26.0f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextSize(F)V

    .line 738
    const/16 v1, 0x5b

    invoke-static {v2, v4, v1, v2}, Landroid/graphics/Color;->argb(IIII)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 739
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 740
    invoke-virtual {p2, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 745
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$CancelItemAdapter;->this$0:Lcom/localytics/android/TestModeListView;

    invoke-virtual {v0}, Lcom/localytics/android/TestModeListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    const/high16 v1, 0x41000000    # 8.0f

    mul-float/2addr v0, v1

    .line 746
    new-instance v1, Landroid/graphics/drawable/GradientDrawable;

    sget-object v2, Landroid/graphics/drawable/GradientDrawable$Orientation;->TL_BR:Landroid/graphics/drawable/GradientDrawable$Orientation;

    new-array v3, v7, [I

    fill-array-data v3, :array_0

    invoke-direct {v1, v2, v3}, Landroid/graphics/drawable/GradientDrawable;-><init>(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V

    .line 747
    invoke-virtual {v1, v4}, Landroid/graphics/drawable/GradientDrawable;->setGradientType(I)V

    .line 748
    const/16 v2, 0x8

    new-array v2, v2, [F

    aput v0, v2, v4

    aput v0, v2, v5

    const/4 v3, 0x2

    aput v0, v2, v3

    aput v0, v2, v7

    const/4 v3, 0x4

    aput v0, v2, v3

    const/4 v3, 0x5

    aput v0, v2, v3

    const/4 v3, 0x6

    aput v0, v2, v3

    const/4 v3, 0x7

    aput v0, v2, v3

    invoke-virtual {v1, v2}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadii([F)V

    .line 749
    invoke-static {}, Lcom/localytics/android/DatapointHelper;->getApiLevel()I

    move-result v0

    const/16 v2, 0x10

    if-lt v0, v2, :cond_1

    .line 751
    invoke-virtual {p2, v1}, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 760
    :cond_0
    :goto_0
    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 761
    iget-object v1, p0, Lcom/localytics/android/TestModeListView$CancelItemAdapter;->MENU_ITEMS:[Ljava/lang/String;

    aget-object v1, v1, p1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 762
    const/4 v1, 0x0

    invoke-virtual {v0, v1, v5}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 764
    return-object p2

    .line 755
    :cond_1
    invoke-virtual {p2, v6}, Landroid/view/View;->setBackgroundColor(I)V

    goto :goto_0

    .line 746
    :array_0
    .array-data 4
        -0x1
        -0x1
        -0x1
    .end array-data
.end method
