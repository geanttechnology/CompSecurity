.class public Lcom/wishabi/flipp/app/SearchActivity;
.super Landroid/app/Activity;
.source "SourceFile"


# instance fields
.field private a:Lcom/wishabi/flipp/app/SearchFragment;

.field private final b:Landroid/content/BroadcastReceiver;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 25
    new-instance v0, Lcom/wishabi/flipp/app/dy;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/dy;-><init>(Lcom/wishabi/flipp/app/SearchActivity;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchActivity;->b:Landroid/content/BroadcastReceiver;

    return-void
.end method


# virtual methods
.method public onBackPressed()V
    .locals 2

    .prologue
    .line 110
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 111
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/SearchActivity;->overridePendingTransition(II)V

    .line 113
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 45
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 47
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchActivity;->b:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.intent.action.TIMEZONE_CHANGED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/SearchActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 49
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchActivity;->b:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.intent.action.TIME_SET"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/SearchActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 51
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchActivity;->b:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.intent.action.DATE_CHANGED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/SearchActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 54
    const v0, 0x7f030004

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/SearchActivity;->setContentView(I)V

    .line 56
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0b002c

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/SearchFragment;

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchActivity;->a:Lcom/wishabi/flipp/app/SearchFragment;

    .line 59
    if-nez p1, :cond_1

    .line 61
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "com.wishabi.flipp.search_bundle"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 63
    if-eqz v0, :cond_0

    .line 64
    const-string v1, "search_mode"

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 66
    if-eq v0, v3, :cond_0

    .line 67
    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchActivity;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {}, Lcom/wishabi/flipp/app/en;->a()[I

    move-result-object v2

    aget v0, v2, v0

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/app/SearchFragment;->a(I)V

    .line 71
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/SearchActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 74
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchActivity;->a:Lcom/wishabi/flipp/app/SearchFragment;

    iget v0, v0, Lcom/wishabi/flipp/app/SearchFragment;->b:I

    sget v1, Lcom/wishabi/flipp/app/en;->b:I

    if-ne v0, v1, :cond_3

    .line 76
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchActivity;->a:Lcom/wishabi/flipp/app/SearchFragment;

    iget-object v0, v0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/SearchActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 80
    :goto_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 81
    if-eqz v0, :cond_2

    .line 82
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 83
    :cond_2
    return-void

    .line 78
    :cond_3
    const v0, 0x7f0e011e

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/SearchActivity;->setTitle(I)V

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 39
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 40
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchActivity;->b:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/SearchActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 41
    return-void
.end method

.method public onNewIntent(Landroid/content/Intent;)V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 117
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchActivity;->a:Lcom/wishabi/flipp/app/SearchFragment;

    if-eqz v0, :cond_2

    const-string v0, "android.intent.action.SEARCH"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 120
    const-string v0, "com.wishabi.flipp.search_bundle"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 123
    const/4 v0, 0x1

    .line 124
    if-eqz v1, :cond_1

    .line 127
    const-string v2, "search_mode"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 129
    if-eq v1, v3, :cond_1

    .line 130
    invoke-static {}, Lcom/wishabi/flipp/app/en;->a()[I

    move-result-object v2

    aget v1, v2, v1

    .line 132
    sget v2, Lcom/wishabi/flipp/app/en;->b:I

    if-ne v1, v2, :cond_0

    .line 133
    const/4 v0, 0x0

    .line 134
    :cond_0
    iget-object v2, p0, Lcom/wishabi/flipp/app/SearchActivity;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v2, v1}, Lcom/wishabi/flipp/app/SearchFragment;->a(I)V

    .line 138
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchActivity;->a:Lcom/wishabi/flipp/app/SearchFragment;

    const-string v2, "query"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/wishabi/flipp/app/SearchFragment;->a(Ljava/lang/String;Z)V

    .line 141
    :cond_2
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    .line 87
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x102002c

    if-ne v0, v1, :cond_1

    .line 88
    invoke-static {p0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;)Landroid/content/Intent;

    move-result-object v0

    .line 94
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-lt v1, v2, :cond_0

    invoke-static {p0, v0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 96
    invoke-static {p0}, Landroid/support/v4/app/dd;->a(Landroid/content/Context;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/dd;->a(Landroid/app/Activity;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/dd;->a()V

    .line 102
    :goto_0
    const/4 v0, 0x1

    .line 105
    :goto_1
    return v0

    .line 98
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchActivity;->finish()V

    .line 99
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/SearchActivity;->overridePendingTransition(II)V

    goto :goto_0

    .line 105
    :cond_1
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_1
.end method
