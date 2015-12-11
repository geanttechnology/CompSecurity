.class public final Lcom/wishabi/flipp/app/aa;
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


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 27
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 31
    sput-object v0, Lcom/wishabi/flipp/app/aa;->b:Ljava/util/HashMap;

    const-class v1, Lcom/wishabi/flipp/app/n;

    const-string v2, "coupon_details"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    sget-object v0, Lcom/wishabi/flipp/app/aa;->b:Ljava/util/HashMap;

    const-class v1, Lcom/wishabi/flipp/app/e;

    const-string v2, "barcode"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 33
    sget-object v0, Lcom/wishabi/flipp/app/aa;->b:Ljava/util/HashMap;

    const-class v1, Lcom/wishabi/flipp/app/z;

    const-string v2, "coupon_help"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 35
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/wishabi/flipp/app/dp;-><init>()V

    return-void
.end method

.method public static a([IZLcom/wishabi/flipp/b/p;)Lcom/wishabi/flipp/app/aa;
    .locals 2

    .prologue
    .line 40
    new-instance v0, Lcom/wishabi/flipp/app/aa;

    invoke-direct {v0}, Lcom/wishabi/flipp/app/aa;-><init>()V

    .line 41
    invoke-static {p0, p1, p2}, Lcom/wishabi/flipp/app/n;->a([IZLcom/wishabi/flipp/b/p;)Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/aa;->setArguments(Landroid/os/Bundle;)V

    .line 44
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
    .line 116
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/dl;

    .line 117
    invoke-virtual {v0, p2}, Lcom/wishabi/flipp/app/dl;->setArguments(Landroid/os/Bundle;)V
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2

    .line 123
    sget-object v1, Lcom/wishabi/flipp/app/aa;->b:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 125
    if-nez v1, :cond_0

    .line 137
    :goto_0
    return-void

    .line 128
    :cond_0
    iput-object p0, v0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    .line 129
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/aa;->getChildFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    .line 130
    const v3, 0x7f050005

    const v4, 0x7f050006

    const v5, 0x7f050004

    const v6, 0x7f050007

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/app/FragmentTransaction;->setCustomAnimations(IIII)Landroid/app/FragmentTransaction;

    .line 134
    const v3, 0x7f0b00fe

    invoke-virtual {v2, v3, v0, v1}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 135
    const/4 v0, 0x0

    invoke-virtual {v2, v0}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 136
    invoke-virtual {v2}, Landroid/app/FragmentTransaction;->commit()I

    goto :goto_0

    .line 120
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
    .line 108
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/aa;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/app/Dialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 109
    return-void
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 141
    const/4 v0, 0x1

    return v0
.end method

.method public final onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 50
    const v0, 0x7f030044

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public final onResume()V
    .locals 4

    .prologue
    .line 96
    invoke-super {p0}, Lcom/wishabi/flipp/app/dp;->onResume()V

    .line 98
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/aa;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    .line 99
    if-eqz v0, :cond_0

    .line 100
    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/aa;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0a001e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/aa;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0a001d

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    float-to-int v2, v2

    invoke-virtual {v0, v1, v2}, Landroid/view/Window;->setLayout(II)V

    .line 104
    :cond_0
    return-void
.end method

.method public final onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .prologue
    .line 55
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/aa;->setCancelable(Z)V

    .line 57
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/aa;->getChildFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 58
    const-string v0, "coupon_details"

    invoke-virtual {v1, v0}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/n;

    .line 61
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/aa;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    .line 62
    if-nez v0, :cond_0

    if-eqz v2, :cond_0

    .line 64
    invoke-static {v2}, Lcom/wishabi/flipp/app/n;->a(Landroid/os/Bundle;)Lcom/wishabi/flipp/app/n;

    move-result-object v0

    .line 65
    iput-object p0, v0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    .line 66
    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    .line 67
    const v3, 0x7f0b00fe

    const-string v4, "coupon_details"

    invoke-virtual {v2, v3, v0, v4}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 68
    invoke-virtual {v2}, Landroid/app/FragmentTransaction;->commit()I

    .line 72
    :cond_0
    sget-object v0, Lcom/wishabi/flipp/app/aa;->b:Ljava/util/HashMap;

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

    .line 73
    invoke-virtual {v1, v0}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    .line 74
    if-eqz v0, :cond_1

    instance-of v3, v0, Lcom/wishabi/flipp/app/dl;

    if-eqz v3, :cond_1

    .line 75
    check-cast v0, Lcom/wishabi/flipp/app/dl;

    .line 76
    iput-object p0, v0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    goto :goto_0

    .line 80
    :cond_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/aa;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    new-instance v1, Lcom/wishabi/flipp/app/ab;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/ab;-><init>(Lcom/wishabi/flipp/app/aa;)V

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)V

    .line 92
    return-void
.end method
