.class final Lcom/localytics/android/TestModeListView$MenuItemAdapter;
.super Landroid/widget/BaseAdapter;
.source "SourceFile"


# instance fields
.field private final MENU_ITEMS:[Ljava/lang/String;

.field private final mContext:Landroid/content/Context;

.field final synthetic this$0:Lcom/localytics/android/TestModeListView;


# direct methods
.method public constructor <init>(Lcom/localytics/android/TestModeListView;Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 593
    iput-object p1, p0, Lcom/localytics/android/TestModeListView$MenuItemAdapter;->this$0:Lcom/localytics/android/TestModeListView;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 588
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "Disable Test Mode"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "Refresh"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "Copy Push Token"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "Copy Install ID"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/localytics/android/TestModeListView$MenuItemAdapter;->MENU_ITEMS:[Ljava/lang/String;

    .line 594
    iput-object p2, p0, Lcom/localytics/android/TestModeListView$MenuItemAdapter;->mContext:Landroid/content/Context;

    .line 595
    return-void
.end method

.method private getShape(I)Landroid/graphics/drawable/Drawable;
    .locals 9

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x3

    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 617
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuItemAdapter;->this$0:Lcom/localytics/android/TestModeListView;

    invoke-virtual {v0}, Lcom/localytics/android/TestModeListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    const/high16 v1, 0x41000000    # 8.0f

    mul-float/2addr v0, v1

    .line 619
    new-instance v1, Landroid/graphics/drawable/GradientDrawable;

    sget-object v2, Landroid/graphics/drawable/GradientDrawable$Orientation;->TL_BR:Landroid/graphics/drawable/GradientDrawable$Orientation;

    new-array v3, v6, [I

    fill-array-data v3, :array_0

    invoke-direct {v1, v2, v3}, Landroid/graphics/drawable/GradientDrawable;-><init>(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V

    .line 620
    invoke-virtual {v1, v5}, Landroid/graphics/drawable/GradientDrawable;->setGradientType(I)V

    .line 621
    packed-switch p1, :pswitch_data_0

    .line 634
    :goto_0
    :pswitch_0
    return-object v1

    .line 624
    :pswitch_1
    const/16 v2, 0x8

    new-array v2, v2, [F

    aput v0, v2, v5

    aput v0, v2, v7

    aput v0, v2, v8

    aput v0, v2, v6

    const/4 v0, 0x4

    aput v4, v2, v0

    const/4 v0, 0x5

    aput v4, v2, v0

    const/4 v0, 0x6

    aput v4, v2, v0

    const/4 v0, 0x7

    aput v4, v2, v0

    invoke-virtual {v1, v2}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadii([F)V

    goto :goto_0

    .line 630
    :pswitch_2
    const/16 v2, 0x8

    new-array v2, v2, [F

    aput v4, v2, v5

    aput v4, v2, v7

    aput v4, v2, v8

    aput v4, v2, v6

    const/4 v3, 0x4

    aput v0, v2, v3

    const/4 v3, 0x5

    aput v0, v2, v3

    const/4 v3, 0x6

    aput v0, v2, v3

    const/4 v3, 0x7

    aput v0, v2, v3

    invoke-virtual {v1, v2}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadii([F)V

    goto :goto_0

    .line 619
    nop

    :array_0
    .array-data 4
        -0x1
        -0x1
        -0x1
    .end array-data

    .line 621
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method public final getCount()I
    .locals 1

    .prologue
    .line 600
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuItemAdapter;->MENU_ITEMS:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public final bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 586
    invoke-virtual {p0, p1}, Lcom/localytics/android/TestModeListView$MenuItemAdapter;->getItem(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getItem(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 606
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuItemAdapter;->MENU_ITEMS:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public final getItemId(I)J
    .locals 2

    .prologue
    .line 612
    int-to-long v0, p1

    return-wide v0
.end method

.method public final getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    const/16 v5, 0xff

    const/4 v4, -0x1

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 641
    .line 643
    if-nez p2, :cond_0

    .line 645
    new-instance p2, Landroid/widget/LinearLayout;

    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuItemAdapter;->mContext:Landroid/content/Context;

    invoke-direct {p2, v0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 646
    new-instance v0, Landroid/widget/AbsListView$LayoutParams;

    const/4 v1, -0x2

    invoke-direct {v0, v4, v1}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    invoke-virtual {p2, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 647
    invoke-virtual {p2, v3}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 648
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuItemAdapter;->mContext:Landroid/content/Context;

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

    .line 649
    invoke-virtual {p2, v2, v0, v2, v0}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 652
    new-instance v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/localytics/android/TestModeListView$MenuItemAdapter;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 653
    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setId(I)V

    .line 654
    const/high16 v1, 0x41d00000    # 26.0f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextSize(F)V

    .line 655
    const/16 v1, 0x5b

    invoke-static {v5, v2, v1, v5}, Landroid/graphics/Color;->argb(IIII)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 656
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 657
    invoke-virtual {p2, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 662
    invoke-static {}, Lcom/localytics/android/DatapointHelper;->getApiLevel()I

    move-result v0

    const/16 v1, 0x10

    if-lt v0, v1, :cond_1

    .line 664
    invoke-direct {p0, p1}, Lcom/localytics/android/TestModeListView$MenuItemAdapter;->getShape(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 673
    :cond_0
    :goto_0
    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 674
    iget-object v1, p0, Lcom/localytics/android/TestModeListView$MenuItemAdapter;->MENU_ITEMS:[Ljava/lang/String;

    aget-object v1, v1, p1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 676
    packed-switch p1, :pswitch_data_0

    .line 680
    :goto_1
    return-object p2

    .line 668
    :cond_1
    invoke-virtual {p2, v4}, Landroid/view/View;->setBackgroundColor(I)V

    goto :goto_0

    .line 679
    :pswitch_0
    const/high16 v1, -0x10000

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1

    .line 676
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
