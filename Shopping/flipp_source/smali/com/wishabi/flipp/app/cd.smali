.class public final Lcom/wishabi/flipp/app/cd;
.super Lcom/wishabi/flipp/app/dp;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/app/dm;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x11
.end annotation


# static fields
.field private static final b:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private c:Landroid/os/Bundle;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 26
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 30
    sput-object v0, Lcom/wishabi/flipp/app/cd;->b:Ljava/util/HashMap;

    const-class v1, Lcom/wishabi/flipp/app/bx;

    const-string v2, "flyer_info"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 31
    sget-object v0, Lcom/wishabi/flipp/app/cd;->b:Ljava/util/HashMap;

    const-class v1, Lcom/wishabi/flipp/app/fu;

    const-string v2, "webview"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/wishabi/flipp/app/dp;-><init>()V

    return-void
.end method

.method public static a(ILjava/lang/String;ZZ)Lcom/wishabi/flipp/app/cd;
    .locals 2

    .prologue
    .line 38
    new-instance v0, Lcom/wishabi/flipp/app/cd;

    invoke-direct {v0}, Lcom/wishabi/flipp/app/cd;-><init>()V

    .line 39
    invoke-static {p0, p1, p2, p3}, Lcom/wishabi/flipp/app/bx;->a(ILjava/lang/String;ZZ)Landroid/os/Bundle;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/app/cd;->c:Landroid/os/Bundle;

    .line 41
    return-object v0
.end method


# virtual methods
.method public final a(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 7
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
    .line 113
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/dl;

    .line 114
    invoke-virtual {v0, p2}, Lcom/wishabi/flipp/app/dl;->setArguments(Landroid/os/Bundle;)V
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2

    .line 120
    sget-object v1, Lcom/wishabi/flipp/app/cd;->b:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 122
    if-nez v1, :cond_0

    .line 134
    :goto_0
    return-void

    .line 125
    :cond_0
    iput-object p0, v0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    .line 126
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cd;->getChildFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    .line 127
    const v3, 0x7f050005

    const v4, 0x7f050006

    const v5, 0x7f050004

    const v6, 0x7f050007

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/app/FragmentTransaction;->setCustomAnimations(IIII)Landroid/app/FragmentTransaction;

    .line 131
    const v3, 0x7f0b00fe

    invoke-virtual {v2, v3, v0, v1}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 132
    const/4 v0, 0x0

    invoke-virtual {v2, v0}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 133
    invoke-virtual {v2}, Landroid/app/FragmentTransaction;->commit()I

    goto :goto_0

    .line 117
    :catch_0
    move-exception v0

    goto :goto_0

    :catch_1
    move-exception v0

    goto :goto_0

    :catch_2
    move-exception v0

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 105
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cd;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/app/Dialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 106
    return-void
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 138
    const/4 v0, 0x1

    return v0
.end method

.method public final onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 47
    const v0, 0x7f030044

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public final onResume()V
    .locals 4

    .prologue
    .line 93
    invoke-super {p0}, Lcom/wishabi/flipp/app/dp;->onResume()V

    .line 95
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cd;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    .line 96
    if-eqz v0, :cond_0

    .line 97
    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cd;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0a001e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cd;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0a001d

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    float-to-int v2, v2

    invoke-virtual {v0, v1, v2}, Landroid/view/Window;->setLayout(II)V

    .line 101
    :cond_0
    return-void
.end method

.method public final onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .prologue
    .line 52
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/cd;->setCancelable(Z)V

    .line 54
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cd;->getChildFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 55
    const-string v0, "flyer_info"

    invoke-virtual {v1, v0}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/bx;

    .line 58
    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/cd;->c:Landroid/os/Bundle;

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lcom/wishabi/flipp/app/cd;->c:Landroid/os/Bundle;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bx;->a(Landroid/os/Bundle;)Lcom/wishabi/flipp/app/bx;

    move-result-object v0

    .line 62
    iput-object p0, v0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    .line 63
    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    .line 64
    const v3, 0x7f0b00fe

    const-string v4, "flyer_info"

    invoke-virtual {v2, v3, v0, v4}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 65
    invoke-virtual {v2}, Landroid/app/FragmentTransaction;->commit()I

    .line 69
    :cond_0
    sget-object v0, Lcom/wishabi/flipp/app/cd;->b:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 70
    invoke-virtual {v1, v0}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    .line 71
    if-eqz v0, :cond_1

    instance-of v3, v0, Lcom/wishabi/flipp/app/dl;

    if-eqz v3, :cond_1

    .line 72
    check-cast v0, Lcom/wishabi/flipp/app/dl;

    .line 73
    iput-object p0, v0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    goto :goto_0

    .line 77
    :cond_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cd;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    new-instance v1, Lcom/wishabi/flipp/app/ce;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/ce;-><init>(Lcom/wishabi/flipp/app/cd;)V

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)V

    .line 89
    return-void
.end method
