.class final Lcom/wishabi/flipp/app/ed;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/SearchFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/SearchFragment;)V
    .locals 0

    .prologue
    .line 981
    iput-object p1, p0, Lcom/wishabi/flipp/app/ed;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 12

    .prologue
    const/4 v1, 0x0

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 984
    iget-object v0, p0, Lcom/wishabi/flipp/app/ed;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->r(Lcom/wishabi/flipp/app/SearchFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ed;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/SearchFragment;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ed;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->e(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ed;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->e(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 986
    iget-object v0, p0, Lcom/wishabi/flipp/app/ed;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/SearchFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v2

    if-nez v2, :cond_1

    sget v0, Lcom/wishabi/flipp/app/fq;->c:I

    .line 988
    :cond_0
    :goto_0
    return-void

    .line 986
    :cond_1
    new-instance v3, Lcom/wishabi/flipp/content/FormattedString;

    const/4 v4, 0x3

    new-array v4, v4, [Lcom/wishabi/flipp/content/FormattedString$Part;

    new-instance v5, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v6, 0x7f0e0149

    invoke-virtual {v2, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    new-array v7, v11, [Lcom/wishabi/flipp/content/FormattedString$Format;

    new-instance v8, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v9, Lcom/wishabi/flipp/content/ab;->a:I

    invoke-direct {v8, v9}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v8, v7, v10

    invoke-direct {v5, v6, v7}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v5, v4, v10

    new-instance v5, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v6, 0x7f0e014a

    invoke-virtual {v2, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    new-array v7, v11, [Lcom/wishabi/flipp/content/FormattedString$Format;

    new-instance v8, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v9, Lcom/wishabi/flipp/content/ab;->b:I

    invoke-direct {v8, v9}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v8, v7, v10

    invoke-direct {v5, v6, v7}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v5, v4, v11

    const/4 v5, 0x2

    new-instance v6, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v7, 0x7f0e014b

    invoke-virtual {v2, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v7, v11, [Lcom/wishabi/flipp/content/FormattedString$Format;

    new-instance v8, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v9, Lcom/wishabi/flipp/content/ab;->a:I

    invoke-direct {v8, v9}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v8, v7, v10

    invoke-direct {v6, v2, v7}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v6, v4, v5

    invoke-direct {v3, v4}, Lcom/wishabi/flipp/content/FormattedString;-><init>([Lcom/wishabi/flipp/content/FormattedString$Part;)V

    const-string v2, "tutorial_showed_coupon_matchup"

    const v4, 0x7f0200f5

    const v5, 0x7f0200f8

    move-object v6, v1

    invoke-static/range {v0 .. v6}, Lcom/wishabi/flipp/app/fp;->a(Landroid/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Lcom/wishabi/flipp/content/FormattedString;IILcom/wishabi/flipp/app/dq;)I

    goto :goto_0
.end method
