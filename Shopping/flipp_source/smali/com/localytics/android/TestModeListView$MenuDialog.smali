.class Lcom/localytics/android/TestModeListView$MenuDialog;
.super Landroid/app/Dialog;
.source "SourceFile"


# instance fields
.field private mDialogLayout:Landroid/widget/LinearLayout;

.field private mMetrics:Landroid/util/DisplayMetrics;

.field final synthetic this$0:Lcom/localytics/android/TestModeListView;


# direct methods
.method public constructor <init>(Lcom/localytics/android/TestModeListView;Landroid/content/Context;I)V
    .locals 0

    .prologue
    .line 446
    iput-object p1, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    .line 447
    invoke-direct {p0, p2, p3}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 449
    invoke-direct {p0}, Lcom/localytics/android/TestModeListView$MenuDialog;->setupViews()V

    .line 451
    invoke-direct {p0}, Lcom/localytics/android/TestModeListView$MenuDialog;->adjustLayout()V

    .line 452
    return-void
.end method

.method private adjustLayout()V
    .locals 4

    .prologue
    const/16 v3, 0x400

    .line 569
    new-instance v0, Landroid/util/DisplayMetrics;

    invoke-direct {v0}, Landroid/util/DisplayMetrics;-><init>()V

    iput-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->mMetrics:Landroid/util/DisplayMetrics;

    .line 570
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    invoke-virtual {v0}, Lcom/localytics/android/TestModeListView;->getActivity()Landroid/support/v4/app/ac;

    move-result-object v0

    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/ac;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 571
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    iget-object v1, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->mMetrics:Landroid/util/DisplayMetrics;

    invoke-virtual {v0, v1}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 576
    invoke-virtual {p0}, Lcom/localytics/android/TestModeListView$MenuDialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 577
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 578
    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v1

    .line 579
    invoke-virtual {v0, v1}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 582
    invoke-virtual {v0, v3, v3}, Landroid/view/Window;->setFlags(II)V

    .line 583
    return-void
.end method

.method private setupViews()V
    .locals 8
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    const/4 v7, -0x1

    const/4 v6, 0x1

    const/16 v5, 0x10

    .line 458
    new-instance v0, Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/localytics/android/TestModeListView$MenuDialog;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->mDialogLayout:Landroid/widget/LinearLayout;

    .line 459
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->mDialogLayout:Landroid/widget/LinearLayout;

    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v2, -0x2

    invoke-direct {v1, v7, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 460
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->mDialogLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setGravity(I)V

    .line 461
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->mDialogLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 463
    invoke-virtual {p0}, Lcom/localytics/android/TestModeListView$MenuDialog;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x106000d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    .line 466
    new-instance v1, Lcom/localytics/android/TestModeListView$MenuItemAdapter;

    iget-object v2, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    iget-object v3, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    invoke-virtual {v3}, Lcom/localytics/android/TestModeListView;->getActivity()Landroid/support/v4/app/ac;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/localytics/android/TestModeListView$MenuItemAdapter;-><init>(Lcom/localytics/android/TestModeListView;Landroid/content/Context;)V

    .line 467
    new-instance v2, Landroid/widget/ListView;

    iget-object v3, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    invoke-virtual {v3}, Lcom/localytics/android/TestModeListView;->getActivity()Landroid/support/v4/app/ac;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 468
    invoke-virtual {v2, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 469
    invoke-static {}, Lcom/localytics/android/DatapointHelper;->getApiLevel()I

    move-result v1

    if-lt v1, v5, :cond_0

    .line 471
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v1, v0}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v2, v1}, Landroid/widget/ListView;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 477
    :goto_0
    invoke-virtual {v2, v6}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 478
    new-instance v1, Lcom/localytics/android/TestModeListView$MenuDialog$1;

    invoke-direct {v1, p0}, Lcom/localytics/android/TestModeListView$MenuDialog$1;-><init>(Lcom/localytics/android/TestModeListView$MenuDialog;)V

    invoke-virtual {v2, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 526
    iget-object v1, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->mDialogLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 529
    new-instance v1, Landroid/view/View;

    iget-object v2, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    invoke-virtual {v2}, Lcom/localytics/android/TestModeListView;->getActivity()Landroid/support/v4/app/ac;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 530
    invoke-static {}, Lcom/localytics/android/DatapointHelper;->getApiLevel()I

    move-result v2

    if-lt v2, v5, :cond_1

    .line 532
    new-instance v2, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v2, v0}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 538
    :goto_1
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    iget-object v3, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    invoke-virtual {v3}, Lcom/localytics/android/TestModeListView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->density:F

    const/high16 v4, 0x41200000    # 10.0f

    mul-float/2addr v3, v4

    const/high16 v4, 0x3f000000    # 0.5f

    add-float/2addr v3, v4

    float-to-int v3, v3

    invoke-direct {v2, v7, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 539
    iget-object v2, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->mDialogLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 541
    new-instance v2, Lcom/localytics/android/TestModeListView$CancelItemAdapter;

    iget-object v3, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    iget-object v4, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    invoke-virtual {v4}, Lcom/localytics/android/TestModeListView;->getActivity()Landroid/support/v4/app/ac;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/localytics/android/TestModeListView$CancelItemAdapter;-><init>(Lcom/localytics/android/TestModeListView;Landroid/content/Context;)V

    .line 542
    new-instance v3, Landroid/widget/ListView;

    iget-object v4, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    invoke-virtual {v4}, Lcom/localytics/android/TestModeListView;->getActivity()Landroid/support/v4/app/ac;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 543
    invoke-virtual {v3, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 544
    invoke-static {}, Lcom/localytics/android/DatapointHelper;->getApiLevel()I

    move-result v2

    if-lt v2, v5, :cond_2

    .line 546
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v1, v0}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v3, v1}, Landroid/widget/ListView;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 552
    :goto_2
    new-instance v0, Lcom/localytics/android/TestModeListView$MenuDialog$2;

    invoke-direct {v0, p0}, Lcom/localytics/android/TestModeListView$MenuDialog$2;-><init>(Lcom/localytics/android/TestModeListView$MenuDialog;)V

    invoke-virtual {v3, v0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 560
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->mDialogLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 562
    invoke-virtual {p0, v6}, Lcom/localytics/android/TestModeListView$MenuDialog;->requestWindowFeature(I)Z

    .line 563
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog;->mDialogLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0, v0}, Lcom/localytics/android/TestModeListView$MenuDialog;->setContentView(Landroid/view/View;)V

    .line 564
    return-void

    .line 475
    :cond_0
    invoke-virtual {v2, v0}, Landroid/widget/ListView;->setBackgroundColor(I)V

    goto/16 :goto_0

    .line 536
    :cond_1
    invoke-virtual {v1, v0}, Landroid/view/View;->setBackgroundColor(I)V

    goto :goto_1

    .line 550
    :cond_2
    invoke-virtual {v1, v0}, Landroid/view/View;->setBackgroundColor(I)V

    goto :goto_2
.end method
