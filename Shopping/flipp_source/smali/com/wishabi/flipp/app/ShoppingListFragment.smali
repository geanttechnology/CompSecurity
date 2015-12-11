.class public Lcom/wishabi/flipp/app/ShoppingListFragment;
.super Landroid/app/Fragment;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/content/ar;
.implements Lcom/wishabi/flipp/content/ay;


# instance fields
.field a:Lcom/wishabi/flipp/content/ShoppingList;

.field b:Lcom/wishabi/flipp/app/ff;

.field c:J

.field private d:Lcom/wishabi/flipp/app/FocusedRecyclerView;

.field private e:Lcom/wishabi/flipp/content/as;

.field private f:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

.field private g:Ljava/lang/String;

.field private h:Landroid/widget/Toast;

.field private i:Landroid/widget/PopupMenu;

.field private j:Landroid/view/View;

.field private k:Landroid/view/View;

.field private l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

.field private m:Landroid/view/ActionMode;

.field private n:Landroid/view/ActionMode$Callback;

.field private o:Lcom/wishabi/flipp/b/ar;

.field private final p:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Lcom/wishabi/flipp/b/as;",
            ">;"
        }
    .end annotation
.end field

.field private q:I

.field private r:Landroid/content/SharedPreferences;

.field private s:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 58
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 90
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->c:J

    .line 91
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->p:Ljava/util/HashMap;

    .line 94
    const/4 v0, 0x0

    iput v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->q:I

    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/ShoppingListFragment;J)J
    .locals 1

    .prologue
    .line 58
    iput-wide p1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->c:J

    return-wide p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/ShoppingListFragment;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->r:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/ShoppingListFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->g:Ljava/lang/String;

    return-object p1
.end method

.method private a(JZ)V
    .locals 5

    .prologue
    .line 872
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    if-nez v0, :cond_1

    .line 892
    :cond_0
    :goto_0
    return-void

    .line 875
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0, p1, p2}, Lcom/wishabi/flipp/content/ShoppingList;->a(J)I

    move-result v0

    .line 877
    if-ltz v0, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    iget-object v1, v1, Lcom/wishabi/flipp/content/as;->d:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v1}, Lcom/wishabi/flipp/content/ShoppingList;->a()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 880
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    iget-object v2, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    iget-wide v2, v2, Lcom/wishabi/flipp/content/ShoppingList;->f:J

    invoke-virtual {v1, v2, v3}, Lcom/wishabi/flipp/content/ShoppingList;->a(J)I

    move-result v1

    .line 882
    if-eq v0, v1, :cond_0

    .line 885
    const/4 v2, -0x1

    if-eq v1, v2, :cond_2

    .line 886
    iget-object v2, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    invoke-virtual {v2, v1}, Lcom/wishabi/flipp/content/as;->c(I)V

    .line 888
    :cond_2
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    iput-wide p1, v1, Lcom/wishabi/flipp/content/ShoppingList;->f:J

    .line 890
    if-eqz p3, :cond_0

    .line 891
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/content/as;->c(I)V

    goto :goto_0
.end method

.method private a(Landroid/view/Menu;)V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 842
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    if-nez v0, :cond_1

    .line 865
    :cond_0
    :goto_0
    return-void

    .line 845
    :cond_1
    const v0, 0x7f0b0161

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 846
    const v1, 0x7f0b0162

    invoke-interface {p1, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    .line 847
    const v2, 0x7f0b0163

    invoke-interface {p1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v2

    .line 848
    const v3, 0x7f0b0164

    invoke-interface {p1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v3

    .line 850
    iget-object v4, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v4}, Lcom/wishabi/flipp/content/ShoppingList;->a()I

    move-result v4

    if-nez v4, :cond_2

    .line 851
    invoke-interface {v0, v5}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 852
    invoke-interface {v3, v5}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 858
    :goto_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    iget v0, v0, Lcom/wishabi/flipp/content/ShoppingList;->g:I

    if-nez v0, :cond_3

    .line 859
    invoke-interface {v1, v5}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 860
    invoke-interface {v2, v5}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    goto :goto_0

    .line 854
    :cond_2
    invoke-interface {v0, v6}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 855
    invoke-interface {v3, v6}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    goto :goto_1

    .line 862
    :cond_3
    invoke-interface {v1, v6}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 863
    invoke-interface {v2, v6}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/ShoppingListFragment;Landroid/view/Menu;)V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Landroid/view/Menu;)V

    return-void
.end method

.method private a(Z)V
    .locals 3

    .prologue
    .line 895
    if-eqz p1, :cond_0

    .line 896
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->isFocused()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    move-object v1, v0

    :goto_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v1, :cond_0

    if-nez v0, :cond_2

    .line 898
    :cond_0
    :goto_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->d:Lcom/wishabi/flipp/app/FocusedRecyclerView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/FocusedRecyclerView;->requestFocus()Z

    .line 899
    return-void

    .line 896
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->d:Lcom/wishabi/flipp/app/FocusedRecyclerView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/FocusedRecyclerView;->getFocusedChild()Landroid/view/View;

    move-result-object v0

    move-object v1, v0

    goto :goto_0

    :cond_2
    const-string v2, "input_method"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    if-eqz v0, :cond_0

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    goto :goto_1
.end method

.method private a(Landroid/view/MenuItem;)Z
    .locals 9

    .prologue
    const/4 v8, 0x0

    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 815
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 838
    :goto_0
    return v0

    .line 817
    :pswitch_0
    iget-object v2, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    iget-object v3, v2, Lcom/wishabi/flipp/content/ShoppingList;->d:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    const-string v5, "checked"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string v5, "datetime_updated"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    sget-object v5, Lcom/wishabi/flipp/content/i;->k:Landroid/net/Uri;

    const-string v6, "shopping_list_id = ? AND checked = ?"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/String;

    iget v2, v2, Lcom/wishabi/flipp/content/ShoppingList;->c:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v7, v0

    const-string v0, "1"

    aput-object v0, v7, v1

    invoke-virtual {v3, v5, v4, v6, v7}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 818
    sget-object v2, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    sget v3, Lcom/wishabi/flipp/b/s;->h:I

    invoke-virtual {v2, v8, v3, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;II)V

    :goto_1
    move v0, v1

    .line 838
    goto :goto_0

    .line 822
    :pswitch_1
    iget-object v2, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    iget-object v3, v2, Lcom/wishabi/flipp/content/ShoppingList;->d:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    sget-object v4, Lcom/wishabi/flipp/content/i;->k:Landroid/net/Uri;

    const-string v5, "shopping_list_id = ? AND checked = 1"

    new-array v6, v1, [Ljava/lang/String;

    iget v2, v2, Lcom/wishabi/flipp/content/ShoppingList;->c:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v6, v0

    invoke-virtual {v3, v4, v5, v6}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 823
    sget-object v2, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    sget v3, Lcom/wishabi/flipp/b/s;->f:I

    invoke-virtual {v2, v8, v3, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;II)V

    goto :goto_1

    .line 827
    :pswitch_2
    iget-object v2, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    iget-object v3, v2, Lcom/wishabi/flipp/content/ShoppingList;->d:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    sget-object v4, Lcom/wishabi/flipp/content/i;->k:Landroid/net/Uri;

    const-string v5, "shopping_list_id = ?"

    new-array v6, v1, [Ljava/lang/String;

    iget v2, v2, Lcom/wishabi/flipp/content/ShoppingList;->c:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v6, v0

    invoke-virtual {v3, v4, v5, v6}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 828
    sget-object v2, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    sget v3, Lcom/wishabi/flipp/b/s;->g:I

    invoke-virtual {v2, v8, v3, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;II)V

    goto :goto_1

    .line 832
    :pswitch_3
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->c()V

    goto :goto_1

    .line 815
    :pswitch_data_0
    .packed-switch 0x7f0b0161
        :pswitch_3
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/ShoppingListFragment;Landroid/view/MenuItem;)Z
    .locals 1

    .prologue
    .line 58
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/ShoppingList;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    return-object v0
.end method

.method private b()V
    .locals 4

    .prologue
    .line 765
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->f:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    if-nez v0, :cond_1

    .line 776
    :cond_0
    :goto_0
    return-void

    .line 768
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/ShoppingList;->a()I

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->f:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_2

    .line 770
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->f:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->setVisibility(I)V

    .line 771
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->f:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->setAlpha(F)V

    .line 772
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->f:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0x258

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    goto :goto_0

    .line 773
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/ShoppingList;->a()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->f:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 775
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->f:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->setVisibility(I)V

    goto :goto_0
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/app/ff;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    return-object v0
.end method

.method private c()V
    .locals 3

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 902
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->i:Landroid/widget/PopupMenu;

    if-nez v0, :cond_1

    .line 903
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->n:Landroid/view/ActionMode$Callback;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->m:Landroid/view/ActionMode;

    .line 911
    :cond_0
    :goto_0
    return-void

    .line 904
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->j:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->k:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 905
    invoke-direct {p0, v1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Z)V

    .line 906
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/content/as;->a(Z)V

    .line 907
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->j:Landroid/view/View;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 908
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->k:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 909
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->setEnabled(Z)V

    goto :goto_0
.end method

.method private d()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 914
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->m:Landroid/view/ActionMode;

    if-eqz v0, :cond_1

    .line 915
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->m:Landroid/view/ActionMode;

    invoke-virtual {v0}, Landroid/view/ActionMode;->finish()V

    .line 916
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->m:Landroid/view/ActionMode;

    .line 924
    :cond_0
    :goto_0
    return-void

    .line 917
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->j:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->k:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 918
    invoke-direct {p0, v2}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Z)V

    .line 919
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/content/as;->a(Z)V

    .line 920
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->j:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 921
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->k:Landroid/view/View;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 922
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->setEnabled(Z)V

    goto :goto_0
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/ShoppingListFragment;)V
    .locals 1

    .prologue
    .line 58
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Z)V

    return-void
.end method

.method static synthetic e(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/content/as;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    return-object v0
.end method

.method private e()V
    .locals 3

    .prologue
    .line 947
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->p:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/b/as;

    .line 948
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/b/as;->cancel(Z)Z

    goto :goto_0

    .line 950
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->p:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 951
    return-void
.end method

.method static synthetic f(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    return-object v0
.end method

.method static synthetic g(Lcom/wishabi/flipp/app/ShoppingListFragment;)Lcom/wishabi/flipp/app/FocusedRecyclerView;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->d:Lcom/wishabi/flipp/app/FocusedRecyclerView;

    return-object v0
.end method

.method static synthetic h(Lcom/wishabi/flipp/app/ShoppingListFragment;)Landroid/widget/PopupMenu;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->i:Landroid/widget/PopupMenu;

    return-object v0
.end method

.method static synthetic i(Lcom/wishabi/flipp/app/ShoppingListFragment;)V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->d()V

    return-void
.end method

.method static synthetic j(Lcom/wishabi/flipp/app/ShoppingListFragment;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->p:Ljava/util/HashMap;

    return-object v0
.end method


# virtual methods
.method public final a()V
    .locals 0

    .prologue
    .line 761
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->b()V

    .line 762
    return-void
.end method

.method public final a(I)V
    .locals 1

    .prologue
    .line 707
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    if-nez v0, :cond_0

    .line 711
    :goto_0
    return-void

    .line 710
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/content/as;->c(I)V

    goto :goto_0
.end method

.method public final a(Landroid/widget/EditText;)V
    .locals 1

    .prologue
    .line 684
    const-string v0, ""

    invoke-virtual {p1, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 685
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Z)V

    .line 686
    return-void
.end method

.method public final a(Lcom/wishabi/flipp/content/ShoppingList;)V
    .locals 2

    .prologue
    .line 690
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    if-nez v0, :cond_0

    .line 702
    :goto_0
    return-void

    .line 693
    :cond_0
    iget-wide v0, p1, Lcom/wishabi/flipp/content/ShoppingList;->f:J

    invoke-virtual {p1, v0, v1}, Lcom/wishabi/flipp/content/ShoppingList;->b(J)Lcom/wishabi/flipp/content/az;

    move-result-object v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    if-eqz v0, :cond_1

    .line 695
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    invoke-interface {v0}, Lcom/wishabi/flipp/app/ff;->a()V

    .line 697
    :cond_1
    invoke-virtual {p1}, Lcom/wishabi/flipp/content/ShoppingList;->b()I

    move-result v0

    if-nez v0, :cond_2

    .line 698
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->e()V

    .line 700
    :cond_2
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->b()V

    .line 701
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Landroid/support/v7/widget/an;->a:Landroid/support/v7/widget/ao;

    invoke-virtual {v0}, Landroid/support/v7/widget/ao;->b()V

    goto :goto_0
.end method

.method public final a(Lcom/wishabi/flipp/content/az;)V
    .locals 4

    .prologue
    const/4 v2, 0x1

    .line 467
    invoke-direct {p0, v2}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Z)V

    .line 469
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_0

    .line 490
    :goto_0
    return-void

    .line 472
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    if-eqz v0, :cond_1

    .line 473
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->b()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/app/ff;->a(Ljava/lang/String;)V

    .line 474
    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v0

    invoke-direct {p0, v0, v1, v2}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(JZ)V

    goto :goto_0

    .line 476
    :cond_1
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-class v2, Lcom/wishabi/flipp/app/SearchActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 477
    const-string v1, "android.intent.action.SEARCH"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 478
    const-string v1, "query"

    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 480
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 481
    const-string v2, "search_mode"

    sget v3, Lcom/wishabi/flipp/app/en;->b:I

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 483
    const-string v2, "com.wishabi.flipp.search_bundle"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 485
    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->startActivity(Landroid/content/Intent;)V

    .line 487
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_0
.end method

.method public final a(Lcom/wishabi/flipp/content/az;IZ)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 716
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    if-nez v0, :cond_0

    .line 733
    :goto_0
    return-void

    .line 719
    :cond_0
    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->c:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    .line 720
    iput-boolean v4, p1, Lcom/wishabi/flipp/content/az;->c:Z

    .line 722
    :cond_1
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->b()V

    .line 724
    if-eqz p3, :cond_3

    .line 725
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    add-int/lit8 v1, p2, -0x1

    iget-object v0, v0, Landroid/support/v7/widget/an;->a:Landroid/support/v7/widget/ao;

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/widget/ao;->a(II)V

    .line 729
    :goto_1
    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->c:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_2

    .line 730
    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v0

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(JZ)V

    .line 732
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->d:Lcom/wishabi/flipp/app/FocusedRecyclerView;

    iget-object v1, v0, Landroid/support/v7/widget/RecyclerView;->f:Landroid/support/v7/widget/au;

    invoke-virtual {v1, v0, p2}, Landroid/support/v7/widget/au;->a(Landroid/support/v7/widget/RecyclerView;I)V

    goto :goto_0

    .line 727
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Landroid/support/v7/widget/an;->a:Landroid/support/v7/widget/ao;

    invoke-virtual {v0, p2, v4}, Landroid/support/v7/widget/ao;->a(II)V

    goto :goto_1
.end method

.method public final a(Lcom/wishabi/flipp/widget/db;)V
    .locals 1

    .prologue
    .line 494
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lcom/wishabi/flipp/widget/db;->setPressed(Z)V

    .line 495
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->c()V

    .line 496
    return-void
.end method

.method public final a(Lcom/wishabi/flipp/widget/db;Lcom/wishabi/flipp/content/az;Z)V
    .locals 10

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 565
    if-nez p2, :cond_0

    .line 576
    :goto_0
    return-void

    .line 568
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    iget-object v0, v0, Lcom/wishabi/flipp/content/ShoppingList;->d:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    const-string v5, "checked"

    if-eqz p3, :cond_2

    move v0, v1

    :goto_1
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v4, v5, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    const-string v0, "datetime_updated"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v4, v0, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    sget-object v0, Lcom/wishabi/flipp/content/i;->k:Landroid/net/Uri;

    const-string v5, "id = ?"

    new-array v6, v1, [Ljava/lang/String;

    invoke-virtual {p2}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v2

    invoke-virtual {v3, v0, v4, v5, v6}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 570
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->d:Lcom/wishabi/flipp/app/FocusedRecyclerView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/FocusedRecyclerView;->getFocusedChild()Landroid/view/View;

    move-result-object v0

    if-ne v0, p1, :cond_1

    .line 571
    invoke-direct {p0, v1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Z)V

    .line 573
    :cond_1
    sget-object v1, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    invoke-virtual {p2}, Lcom/wishabi/flipp/content/az;->b()Ljava/lang/String;

    move-result-object v2

    if-eqz p3, :cond_3

    sget v0, Lcom/wishabi/flipp/b/s;->i:I

    :goto_2
    iget v3, p2, Lcom/wishabi/flipp/content/az;->b:I

    invoke-virtual {v1, v2, v0, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;II)V

    goto :goto_0

    :cond_2
    move v0, v2

    .line 568
    goto :goto_1

    .line 573
    :cond_3
    sget v0, Lcom/wishabi/flipp/b/s;->j:I

    goto :goto_2
.end method

.method final a(Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 784
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 785
    if-nez v0, :cond_1

    .line 812
    :cond_0
    :goto_0
    return-void

    .line 788
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->h:Landroid/widget/Toast;

    if-nez v1, :cond_2

    .line 789
    new-instance v1, Landroid/widget/Toast;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/Toast;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->h:Landroid/widget/Toast;

    .line 790
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->h:Landroid/widget/Toast;

    const/16 v2, 0x50

    const/4 v3, 0x1

    const/high16 v4, 0x425c0000    # 55.0f

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    invoke-static {v3, v4, v5}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v3

    float-to-int v3, v3

    invoke-virtual {v1, v2, v6, v3}, Landroid/widget/Toast;->setGravity(III)V

    .line 794
    invoke-virtual {v0}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f03002e

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 796
    if-eqz v0, :cond_0

    .line 799
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->h:Landroid/widget/Toast;

    invoke-virtual {v1, v0}, Landroid/widget/Toast;->setView(Landroid/view/View;)V

    .line 802
    :cond_2
    if-nez p1, :cond_3

    .line 803
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->h:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->cancel()V

    goto :goto_0

    .line 807
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->h:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0b00c2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 809
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 810
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->h:Landroid/widget/Toast;

    invoke-virtual {v0, v6}, Landroid/widget/Toast;->setDuration(I)V

    .line 811
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->h:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

.method public final a(Lcom/wishabi/flipp/widget/db;Lcom/wishabi/flipp/content/az;)Z
    .locals 11

    .prologue
    const/4 v10, -0x1

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 593
    if-nez p2, :cond_0

    .line 594
    invoke-direct {p0, v9}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Z)V

    .line 619
    :goto_0
    return v8

    .line 598
    :cond_0
    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/db;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 600
    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 601
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0, p2}, Lcom/wishabi/flipp/content/ShoppingList;->b(Lcom/wishabi/flipp/content/az;)V

    .line 602
    invoke-direct {p0, v9}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Z)V

    goto :goto_0

    .line 606
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    if-eqz v1, :cond_2

    .line 607
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    invoke-interface {v1, v0}, Lcom/wishabi/flipp/app/ff;->a(Ljava/lang/String;)V

    .line 609
    :cond_2
    iput v10, p2, Lcom/wishabi/flipp/content/az;->b:I

    iput-boolean v8, p2, Lcom/wishabi/flipp/content/az;->c:Z

    .line 610
    iput-boolean v9, p2, Lcom/wishabi/flipp/content/az;->c:Z

    .line 611
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    if-eqz v0, :cond_3

    const-string v2, ""

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 612
    :cond_3
    :goto_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {p2}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/wishabi/flipp/content/ShoppingList;->d(J)V

    .line 613
    invoke-virtual {p2}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v2

    invoke-direct {p0, v2, v3, v8}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(JZ)V

    .line 614
    invoke-direct {p0, v9}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Z)V

    .line 616
    sget-object v1, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    sget v2, Lcom/wishabi/flipp/b/s;->d:I

    invoke-virtual {v1, v0, v2, v10}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;II)V

    goto :goto_0

    .line 611
    :cond_4
    iget-object v1, v1, Lcom/wishabi/flipp/content/ShoppingList;->d:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    const-string v3, "name"

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "datetime_updated"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    sget-object v3, Lcom/wishabi/flipp/content/i;->k:Landroid/net/Uri;

    const-string v4, "id = ?"

    new-array v5, v9, [Ljava/lang/String;

    invoke-virtual {p2}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-virtual {v1, v3, v2, v4, v5}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_1
.end method

.method public final b(Lcom/wishabi/flipp/content/az;)V
    .locals 9

    .prologue
    .line 501
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->g:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 560
    :cond_0
    :goto_0
    return-void

    .line 504
    :cond_1
    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v6

    .line 505
    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->b()Ljava/lang/String;

    move-result-object v8

    .line 506
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0, v6, v7}, Lcom/wishabi/flipp/content/ShoppingList;->c(J)Lcom/wishabi/flipp/content/SimpleSearchResult;

    move-result-object v1

    .line 507
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->p:Ljava/util/HashMap;

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/b/as;

    .line 508
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 510
    if-nez v0, :cond_0

    if-eqz v1, :cond_2

    iget-wide v0, v1, Lcom/wishabi/flipp/content/SimpleSearchResult;->c:J

    cmp-long v0, v2, v0

    if-ltz v0, :cond_0

    .line 514
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/wishabi/flipp/content/ShoppingList;->d(J)V

    .line 516
    new-instance v1, Lcom/wishabi/flipp/app/ew;

    iget-object v3, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->g:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v5

    move-object v2, p0

    invoke-direct/range {v1 .. v8}, Lcom/wishabi/flipp/app/ew;-><init>(Lcom/wishabi/flipp/app/ShoppingListFragment;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;JLjava/lang/String;)V

    .line 558
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->p:Ljava/util/HashMap;

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 559
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Void;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/b/as;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public final b(Lcom/wishabi/flipp/content/az;IZ)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 738
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    if-nez v0, :cond_0

    .line 757
    :goto_0
    return-void

    .line 741
    :cond_0
    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v0

    iget-object v2, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    iget-wide v2, v2, Lcom/wishabi/flipp/content/ShoppingList;->f:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    if-eqz v0, :cond_1

    .line 742
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    invoke-interface {v0}, Lcom/wishabi/flipp/app/ff;->a()V

    .line 744
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/ShoppingList;->a()I

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    iget-boolean v0, v0, Lcom/wishabi/flipp/content/as;->e:Z

    if-eqz v0, :cond_2

    .line 745
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->d()V

    .line 747
    :cond_2
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->b()V

    .line 749
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->p:Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/b/as;

    .line 750
    if-eqz v0, :cond_3

    .line 751
    invoke-virtual {v0, v4}, Lcom/wishabi/flipp/b/as;->cancel(Z)Z

    .line 753
    :cond_3
    if-eqz p3, :cond_4

    .line 754
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    add-int/lit8 v1, p2, -0x1

    iget-object v0, v0, Landroid/support/v7/widget/an;->a:Landroid/support/v7/widget/ao;

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/widget/ao;->b(II)V

    goto :goto_0

    .line 756
    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Landroid/support/v7/widget/an;->a:Landroid/support/v7/widget/ao;

    invoke-virtual {v0, p2, v4}, Landroid/support/v7/widget/ao;->b(II)V

    goto :goto_0
.end method

.method public final b(Lcom/wishabi/flipp/widget/db;Lcom/wishabi/flipp/content/az;Z)V
    .locals 2

    .prologue
    .line 631
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0, p2}, Lcom/wishabi/flipp/content/ShoppingList;->a(Lcom/wishabi/flipp/content/az;)I

    move-result v0

    .line 633
    if-nez p3, :cond_0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 647
    :cond_0
    :goto_0
    return-void

    .line 643
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->d:Lcom/wishabi/flipp/app/FocusedRecyclerView;

    iget-boolean v1, v1, Lcom/wishabi/flipp/app/FocusedRecyclerView;->p:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->d:Lcom/wishabi/flipp/app/FocusedRecyclerView;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/FocusedRecyclerView;->getScrollState()I

    move-result v1

    if-nez v1, :cond_0

    iget-boolean v1, p1, Lcom/wishabi/flipp/widget/db;->a:Z

    if-nez v1, :cond_0

    .line 646
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/content/as;->c(I)V

    goto :goto_0
.end method

.method public final c(Lcom/wishabi/flipp/content/az;)V
    .locals 4

    .prologue
    .line 581
    if-nez p1, :cond_0

    .line 588
    :goto_0
    return-void

    .line 584
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/content/ShoppingList;->b(Lcom/wishabi/flipp/content/az;)V

    .line 586
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->b()Ljava/lang/String;

    move-result-object v1

    sget v2, Lcom/wishabi/flipp/b/s;->e:I

    iget v3, p1, Lcom/wishabi/flipp/content/az;->b:I

    invoke-virtual {v0, v1, v2, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;II)V

    goto :goto_0
.end method

.method public final d(Lcom/wishabi/flipp/content/az;)V
    .locals 2

    .prologue
    .line 624
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v1, p1}, Lcom/wishabi/flipp/content/ShoppingList;->a(Lcom/wishabi/flipp/content/az;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/content/as;->c(I)V

    .line 625
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Z)V

    .line 626
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 7

    .prologue
    const/4 v1, -0x1

    const/4 v2, 0x0

    const/4 v6, 0x0

    .line 101
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 103
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_0

    .line 194
    :goto_0
    return-void

    .line 106
    :cond_0
    if-eqz p1, :cond_1

    .line 107
    const-string v0, "list_id"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->q:I

    .line 108
    const-string v0, "shopping_list"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/ShoppingList;

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    .line 109
    const-string v0, "postal_code"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->g:Ljava/lang/String;

    .line 112
    :cond_1
    iget v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->q:I

    if-eq v0, v1, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    if-nez v0, :cond_3

    .line 113
    :cond_2
    iput v6, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->q:I

    .line 114
    new-instance v0, Lcom/wishabi/flipp/content/ShoppingList;

    iget v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->q:I

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/content/ShoppingList;-><init>(I)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    .line 118
    :cond_3
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 119
    sget-object v1, Lcom/wishabi/flipp/content/i;->j:Landroid/net/Uri;

    const-string v3, "id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    iget v5, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->q:I

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 123
    if-eqz v1, :cond_4

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-nez v1, :cond_5

    .line 124
    :cond_4
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 125
    const-string v3, "id"

    iget v4, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->q:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 126
    const-string v3, "name"

    const-string v4, "default"

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    sget-object v3, Lcom/wishabi/flipp/content/i;->j:Landroid/net/Uri;

    invoke-virtual {v0, v3, v1}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 130
    :cond_5
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/content/ShoppingList;->d:Landroid/content/Context;

    .line 132
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const-string v1, "com.wishabi.flipp.preferences"

    invoke-virtual {v0, v1, v6}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->r:Landroid/content/SharedPreferences;

    .line 134
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->r:Landroid/content/SharedPreferences;

    const-string v1, "postal_code"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 138
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->g:Ljava/lang/String;

    if-eqz v1, :cond_6

    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->g:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_6

    .line 139
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v1}, Lcom/wishabi/flipp/content/ShoppingList;->c()V

    .line 141
    :cond_6
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    iput-object p0, v1, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    .line 142
    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->g:Ljava/lang/String;

    .line 146
    new-instance v0, Lcom/wishabi/flipp/app/et;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/et;-><init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->s:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    .line 164
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->r:Landroid/content/SharedPreferences;

    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->s:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->registerOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    .line 166
    new-instance v0, Lcom/wishabi/flipp/app/ex;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/ex;-><init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->n:Landroid/view/ActionMode$Callback;

    goto/16 :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 444
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 445
    if-nez v0, :cond_0

    .line 454
    :goto_0
    return-void

    .line 448
    :cond_0
    const v0, 0x7f0b0005

    const v1, 0x7f0e0093

    invoke-interface {p1, v2, v0, v2, v1}, Landroid/view/Menu;->addSubMenu(IIII)Landroid/view/SubMenu;

    move-result-object v0

    .line 450
    invoke-interface {v0}, Landroid/view/SubMenu;->getItem()Landroid/view/MenuItem;

    move-result-object v1

    const/4 v2, 0x2

    invoke-interface {v1, v2}, Landroid/view/MenuItem;->setShowAsAction(I)V

    .line 451
    const v1, 0x7f02009c

    invoke-interface {v0, v1}, Landroid/view/SubMenu;->setIcon(I)Landroid/view/SubMenu;

    .line 452
    const v1, 0x7f10000a

    invoke-virtual {p2, v1, v0}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 201
    const v0, 0x7f03004e

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 204
    const v0, 0x7f0b011d

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    .line 206
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const v5, 0x7f0e0002

    invoke-virtual {v1, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v5, 0x6

    invoke-virtual {v0, v1, v5}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->setImeActionLabel(Ljava/lang/CharSequence;I)V

    .line 209
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    new-instance v1, Lcom/wishabi/flipp/app/ey;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/ey;-><init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 223
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    new-instance v1, Lcom/wishabi/flipp/app/ez;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/ez;-><init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 235
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    new-instance v1, Lcom/wishabi/flipp/app/fa;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/fa;-><init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->setKeyboardDimissedListener(Lcom/wishabi/flipp/widget/au;)V

    .line 244
    const v0, 0x7f0b011b

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/FocusedRecyclerView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->d:Lcom/wishabi/flipp/app/FocusedRecyclerView;

    .line 245
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->d:Lcom/wishabi/flipp/app/FocusedRecyclerView;

    new-instance v1, Lcom/wishabi/flipp/app/fb;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/fb;-><init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/FocusedRecyclerView;->setLayoutManager(Landroid/support/v7/widget/au;)V

    .line 261
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->d:Lcom/wishabi/flipp/app/FocusedRecyclerView;

    new-instance v1, Lcom/wishabi/flipp/app/fc;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/fc;-><init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/FocusedRecyclerView;->setOnScrollListener(Landroid/support/v7/widget/ax;)V

    .line 278
    new-instance v0, Lcom/wishabi/flipp/content/as;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v5, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-direct {v0, v1, v5}, Lcom/wishabi/flipp/content/as;-><init>(Landroid/content/Context;Lcom/wishabi/flipp/content/ShoppingList;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    .line 279
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    iget-object v1, v0, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    if-eqz v1, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Only one listener is allowedfor shopping list"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p0, v0, Lcom/wishabi/flipp/content/as;->c:Lcom/wishabi/flipp/content/ay;

    iget-object v0, v0, Landroid/support/v7/widget/an;->a:Landroid/support/v7/widget/ao;

    invoke-virtual {v0}, Landroid/support/v7/widget/ao;->b()V

    .line 281
    if-eqz p3, :cond_2

    const-string v0, "is_edit_mode"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    move v1, v2

    .line 284
    :goto_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->d:Lcom/wishabi/flipp/app/FocusedRecyclerView;

    iget-object v5, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    invoke-virtual {v0, v5}, Lcom/wishabi/flipp/app/FocusedRecyclerView;->setAdapter(Landroid/support/v7/widget/an;)V

    .line 286
    const v0, 0x7f0b011c

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->f:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    .line 289
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v0

    .line 290
    const-string v5, "fr"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 291
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->f:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    const v5, 0x7f070001

    invoke-static {v5}, Lcom/wishabi/flipp/content/aj;->a(I)Ljava/util/List;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->setItems(Ljava/util/List;)V

    .line 295
    :goto_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->f:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    new-instance v5, Lcom/wishabi/flipp/app/fd;

    invoke-direct {v5, p0}, Lcom/wishabi/flipp/app/fd;-><init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    invoke-virtual {v0, v5}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->setListener(Lcom/wishabi/flipp/widget/dv;)V

    .line 318
    const v0, 0x7f0b0131

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->j:Landroid/view/View;

    .line 319
    const v0, 0x7f0b0130

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->k:Landroid/view/View;

    .line 322
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->j:Landroid/view/View;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->k:Landroid/view/View;

    if-eqz v0, :cond_4

    .line 323
    new-instance v0, Landroid/widget/PopupMenu;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v5

    iget-object v6, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->j:Landroid/view/View;

    invoke-direct {v0, v5, v6}, Landroid/widget/PopupMenu;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->i:Landroid/widget/PopupMenu;

    .line 324
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->i:Landroid/widget/PopupMenu;

    invoke-virtual {v0}, Landroid/widget/PopupMenu;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const v5, 0x7f10000a

    iget-object v6, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->i:Landroid/widget/PopupMenu;

    invoke-virtual {v6}, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 326
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->i:Landroid/widget/PopupMenu;

    new-instance v5, Lcom/wishabi/flipp/app/fe;

    invoke-direct {v5, p0}, Lcom/wishabi/flipp/app/fe;-><init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    invoke-virtual {v0, v5}, Landroid/widget/PopupMenu;->setOnMenuItemClickListener(Landroid/widget/PopupMenu$OnMenuItemClickListener;)V

    .line 335
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->j:Landroid/view/View;

    new-instance v5, Lcom/wishabi/flipp/app/eu;

    invoke-direct {v5, p0}, Lcom/wishabi/flipp/app/eu;-><init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    invoke-virtual {v0, v5}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 343
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->k:Landroid/view/View;

    new-instance v5, Lcom/wishabi/flipp/app/ev;

    invoke-direct {v5, p0}, Lcom/wishabi/flipp/app/ev;-><init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V

    invoke-virtual {v0, v5}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 353
    :goto_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    iget-object v5, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0, v3, v7, v5}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 355
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    iget-object v3, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v0, v2, v7, v3}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 358
    if-eqz v1, :cond_1

    .line 359
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->c()V

    .line 361
    :cond_1
    return-object v4

    :cond_2
    move v1, v3

    .line 281
    goto/16 :goto_0

    .line 293
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->f:Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;

    const/high16 v5, 0x7f070000

    invoke-static {v5}, Lcom/wishabi/flipp/content/aj;->a(I)Ljava/util/List;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/wishabi/flipp/widget/ShoppingListZeroCaseView;->setItems(Ljava/util/List;)V

    goto/16 :goto_1

    .line 350
    :cond_4
    invoke-virtual {p0, v2}, Lcom/wishabi/flipp/app/ShoppingListFragment;->setHasOptionsMenu(Z)V

    goto :goto_2
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 374
    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    .line 375
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->s:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    if-eqz v0, :cond_0

    .line 376
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->r:Landroid/content/SharedPreferences;

    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->s:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->unregisterOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    .line 378
    iput-object v2, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->s:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    .line 379
    iput-object v2, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->r:Landroid/content/SharedPreferences;

    .line 382
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->o:Lcom/wishabi/flipp/b/ar;

    if-eqz v0, :cond_1

    .line 383
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->o:Lcom/wishabi/flipp/b/ar;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/ar;->cancel(Z)Z

    .line 384
    iput-object v2, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->o:Lcom/wishabi/flipp/b/ar;

    .line 387
    :cond_1
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->e()V

    .line 388
    return-void
.end method

.method public onHiddenChanged(Z)V
    .locals 6

    .prologue
    .line 412
    invoke-super {p0, p1}, Landroid/app/Fragment;->onHiddenChanged(Z)V

    .line 414
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 415
    if-nez v0, :cond_1

    .line 440
    :cond_0
    :goto_0
    return-void

    .line 418
    :cond_1
    if-nez p1, :cond_0

    .line 419
    sget-object v1, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v2, "shopping list"

    invoke-virtual {v1, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;)V

    .line 420
    const v1, 0x7f0e0135

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setTitle(Ljava/lang/CharSequence;)V

    .line 422
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->o:Lcom/wishabi/flipp/b/ar;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->o:Lcom/wishabi/flipp/b/ar;

    invoke-virtual {v1}, Lcom/wishabi/flipp/b/ar;->getStatus()Landroid/os/AsyncTask$Status;

    move-result-object v1

    sget-object v2, Landroid/os/AsyncTask$Status;->FINISHED:Landroid/os/AsyncTask$Status;

    if-ne v1, v2, :cond_0

    .line 426
    :cond_2
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->r:Landroid/content/SharedPreferences;

    const-string v2, "last_cat_download"

    const-wide/16 v4, 0x0

    invoke-interface {v1, v2, v4, v5}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    .line 427
    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->r:Landroid/content/SharedPreferences;

    const-string v4, "last_cat_download_locale"

    const-string v5, ""

    invoke-interface {v1, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 430
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v2, v4, v2

    const-wide/32 v4, 0x5265c00

    cmp-long v2, v2, v4

    if-gez v2, :cond_3

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 434
    :cond_3
    new-instance v1, Lcom/wishabi/flipp/b/ar;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/wishabi/flipp/b/ar;-><init>(Landroid/content/ContentResolver;Landroid/content/Context;)V

    iput-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->o:Lcom/wishabi/flipp/b/ar;

    .line 438
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->o:Lcom/wishabi/flipp/b/ar;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/ar;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 458
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x7f0b0005

    if-ne v0, v1, :cond_0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p1}, Landroid/view/MenuItem;->getSubMenu()Landroid/view/SubMenu;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 460
    invoke-interface {p1}, Landroid/view/MenuItem;->getSubMenu()Landroid/view/SubMenu;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Landroid/view/Menu;)V

    .line 462
    :cond_0
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Landroid/view/MenuItem;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-super {p0, p1}, Landroid/app/Fragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 401
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 403
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->isHidden()Z

    move-result v0

    if-nez v0, :cond_0

    .line 404
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v1, "shopping list"

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;)V

    .line 406
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->isFocused()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 407
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->l:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->dismissDropDown()V

    .line 408
    :cond_1
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 392
    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 393
    const-string v0, "list_id"

    iget v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->q:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 394
    const-string v0, "postal_code"

    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->g:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 395
    const-string v0, "is_edit_mode"

    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    iget-boolean v1, v1, Lcom/wishabi/flipp/content/as;->e:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 396
    const-string v0, "shopping_list"

    iget-object v1, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 397
    return-void
.end method

.method public onStart()V
    .locals 1

    .prologue
    .line 366
    invoke-super {p0}, Landroid/app/Fragment;->onStart()V

    .line 368
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    if-eqz v0, :cond_0

    .line 369
    iget-object v0, p0, Lcom/wishabi/flipp/app/ShoppingListFragment;->e:Lcom/wishabi/flipp/content/as;

    iget-object v0, v0, Landroid/support/v7/widget/an;->a:Landroid/support/v7/widget/ao;

    invoke-virtual {v0}, Landroid/support/v7/widget/ao;->b()V

    .line 370
    :cond_0
    return-void
.end method
