.class public Lcom/wishabi/flipp/app/ItemDetailsActivity;
.super Landroid/app/Activity;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/app/dm;


# instance fields
.field private a:Ljava/lang/String;

.field private b:Lcom/wishabi/flipp/app/cx;

.field private final c:Lcom/wishabi/flipp/app/de;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 60
    new-instance v0, Lcom/wishabi/flipp/app/cw;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/cw;-><init>(Lcom/wishabi/flipp/app/ItemDetailsActivity;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/ItemDetailsActivity;->c:Lcom/wishabi/flipp/app/de;

    return-void
.end method

.method public static a(JFLjava/lang/String;)Landroid/content/Intent;
    .locals 4

    .prologue
    .line 39
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    const-string v0, "item_id"

    invoke-virtual {v1, v0, p0, p1}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    const-string v0, "item_ratio"

    invoke-virtual {v1, v0, p2}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    const-string v0, "item_subtitle"

    invoke-virtual {v1, v0, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v2

    if-nez v2, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-class v3, Lcom/wishabi/flipp/app/ItemDetailsActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v2, "item_details_activity_params"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    goto :goto_0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/ItemDetailsActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/wishabi/flipp/app/ItemDetailsActivity;->a:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public final a(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .prologue
    .line 170
    const/4 v0, 0x0

    .line 171
    const-class v1, Lcom/wishabi/flipp/app/n;

    if-ne p1, v1, :cond_0

    .line 172
    invoke-static {p2}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->a(Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v0

    .line 175
    :cond_0
    if-nez v0, :cond_1

    .line 181
    :goto_0
    return-void

    .line 178
    :cond_1
    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->startActivity(Landroid/content/Intent;)V

    .line 179
    const v0, 0x7f040001

    const v1, 0x7f040002

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->overridePendingTransition(II)V

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 165
    return-void
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 185
    const/4 v0, 0x0

    return v0
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 157
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 158
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->overridePendingTransition(II)V

    .line 160
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const-wide/16 v2, 0x0

    const/4 v5, -0x1

    const/high16 v0, 0x3f800000    # 1.0f

    .line 91
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 93
    new-instance v1, Landroid/widget/FrameLayout;

    invoke-direct {v1, p0}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    new-instance v4, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v4, v5, v5}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v1, v4}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 96
    const-string v1, ""

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 101
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v4, "item_details_activity_params"

    invoke-virtual {v1, v4}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 102
    if-eqz v1, :cond_0

    .line 103
    const-string v4, "item_id"

    invoke-virtual {v1, v4, v2, v3}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    .line 104
    const-string v4, "item_ratio"

    invoke-virtual {v1, v4, v0}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;F)F

    move-result v0

    .line 105
    const-string v4, "item_subtitle"

    invoke-virtual {v1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/app/ItemDetailsActivity;->a:Ljava/lang/String;

    .line 108
    :cond_0
    if-nez p1, :cond_2

    .line 109
    invoke-static {v2, v3, v0}, Lcom/wishabi/flipp/app/cx;->b(JF)Lcom/wishabi/flipp/app/cx;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/ItemDetailsActivity;->b:Lcom/wishabi/flipp/app/cx;

    .line 110
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x1020002

    iget-object v2, p0, Lcom/wishabi/flipp/app/ItemDetailsActivity;->b:Lcom/wishabi/flipp/app/cx;

    invoke-virtual {v0, v1, v2}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 118
    :goto_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ItemDetailsActivity;->b:Lcom/wishabi/flipp/app/cx;

    if-eqz v0, :cond_1

    .line 119
    iget-object v0, p0, Lcom/wishabi/flipp/app/ItemDetailsActivity;->b:Lcom/wishabi/flipp/app/cx;

    iget-object v1, p0, Lcom/wishabi/flipp/app/ItemDetailsActivity;->c:Lcom/wishabi/flipp/app/de;

    iput-object v1, v0, Lcom/wishabi/flipp/app/cx;->a:Lcom/wishabi/flipp/app/de;

    .line 120
    iget-object v0, p0, Lcom/wishabi/flipp/app/ItemDetailsActivity;->b:Lcom/wishabi/flipp/app/cx;

    iput-object p0, v0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    .line 122
    :cond_1
    return-void

    .line 113
    :cond_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const-string v1, "item_details_fragment"

    invoke-virtual {v0, p1, v1}, Landroid/app/FragmentManager;->getFragment(Landroid/os/Bundle;Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/cx;

    iput-object v0, p0, Lcom/wishabi/flipp/app/ItemDetailsActivity;->b:Lcom/wishabi/flipp/app/cx;

    goto :goto_0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    .line 134
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x102002c

    if-ne v0, v1, :cond_1

    .line 135
    invoke-static {p0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;)Landroid/content/Intent;

    move-result-object v0

    .line 141
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-lt v1, v2, :cond_0

    invoke-static {p0, v0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 143
    invoke-static {p0}, Landroid/support/v4/app/dd;->a(Landroid/content/Context;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/dd;->a(Landroid/app/Activity;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/dd;->a()V

    .line 149
    :goto_0
    const/4 v0, 0x1

    .line 152
    :goto_1
    return v0

    .line 145
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->finish()V

    .line 146
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->overridePendingTransition(II)V

    goto :goto_0

    .line 152
    :cond_1
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_1
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 126
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 127
    iget-object v0, p0, Lcom/wishabi/flipp/app/ItemDetailsActivity;->b:Lcom/wishabi/flipp/app/cx;

    if-eqz v0, :cond_0

    .line 128
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const-string v1, "item_details_fragment"

    iget-object v2, p0, Lcom/wishabi/flipp/app/ItemDetailsActivity;->b:Lcom/wishabi/flipp/app/cx;

    invoke-virtual {v0, p1, v1, v2}, Landroid/app/FragmentManager;->putFragment(Landroid/os/Bundle;Ljava/lang/String;Landroid/app/Fragment;)V

    .line 130
    :cond_0
    return-void
.end method
