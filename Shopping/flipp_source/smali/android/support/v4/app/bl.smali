.class public final Landroid/support/v4/app/bl;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Landroid/support/v4/app/bs;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 815
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 816
    new-instance v0, Landroid/support/v4/app/bu;

    invoke-direct {v0}, Landroid/support/v4/app/bu;-><init>()V

    sput-object v0, Landroid/support/v4/app/bl;->a:Landroid/support/v4/app/bs;

    .line 832
    :goto_0
    return-void

    .line 817
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x14

    if-lt v0, v1, :cond_1

    .line 818
    new-instance v0, Landroid/support/v4/app/bt;

    invoke-direct {v0}, Landroid/support/v4/app/bt;-><init>()V

    sput-object v0, Landroid/support/v4/app/bl;->a:Landroid/support/v4/app/bs;

    goto :goto_0

    .line 819
    :cond_1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x13

    if-lt v0, v1, :cond_2

    .line 820
    new-instance v0, Landroid/support/v4/app/ca;

    invoke-direct {v0}, Landroid/support/v4/app/ca;-><init>()V

    sput-object v0, Landroid/support/v4/app/bl;->a:Landroid/support/v4/app/bs;

    goto :goto_0

    .line 821
    :cond_2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_3

    .line 822
    new-instance v0, Landroid/support/v4/app/bz;

    invoke-direct {v0}, Landroid/support/v4/app/bz;-><init>()V

    sput-object v0, Landroid/support/v4/app/bl;->a:Landroid/support/v4/app/bs;

    goto :goto_0

    .line 823
    :cond_3
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_4

    .line 824
    new-instance v0, Landroid/support/v4/app/by;

    invoke-direct {v0}, Landroid/support/v4/app/by;-><init>()V

    sput-object v0, Landroid/support/v4/app/bl;->a:Landroid/support/v4/app/bs;

    goto :goto_0

    .line 825
    :cond_4
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_5

    .line 826
    new-instance v0, Landroid/support/v4/app/bx;

    invoke-direct {v0}, Landroid/support/v4/app/bx;-><init>()V

    sput-object v0, Landroid/support/v4/app/bl;->a:Landroid/support/v4/app/bs;

    goto :goto_0

    .line 827
    :cond_5
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x9

    if-lt v0, v1, :cond_6

    .line 828
    new-instance v0, Landroid/support/v4/app/bw;

    invoke-direct {v0}, Landroid/support/v4/app/bw;-><init>()V

    sput-object v0, Landroid/support/v4/app/bl;->a:Landroid/support/v4/app/bs;

    goto :goto_0

    .line 830
    :cond_6
    new-instance v0, Landroid/support/v4/app/bv;

    invoke-direct {v0}, Landroid/support/v4/app/bv;-><init>()V

    sput-object v0, Landroid/support/v4/app/bl;->a:Landroid/support/v4/app/bs;

    goto :goto_0
.end method

.method public static synthetic a()Landroid/support/v4/app/bs;
    .locals 1

    .prologue
    .line 41
    sget-object v0, Landroid/support/v4/app/bl;->a:Landroid/support/v4/app/bs;

    return-object v0
.end method

.method static synthetic a(Landroid/support/v4/app/bj;Ljava/util/ArrayList;)V
    .locals 2

    .prologue
    .line 41
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/bm;

    invoke-interface {p0, v0}, Landroid/support/v4/app/bj;->a(Landroid/support/v4/app/ch;)V

    goto :goto_0

    :cond_0
    return-void
.end method

.method static synthetic a(Landroid/support/v4/app/bk;Landroid/support/v4/app/cb;)V
    .locals 7

    .prologue
    .line 41
    if-eqz p1, :cond_0

    instance-of v0, p1, Landroid/support/v4/app/bp;

    if-eqz v0, :cond_1

    check-cast p1, Landroid/support/v4/app/bp;

    iget-object v0, p1, Landroid/support/v4/app/bp;->e:Ljava/lang/CharSequence;

    iget-boolean v1, p1, Landroid/support/v4/app/bp;->g:Z

    iget-object v2, p1, Landroid/support/v4/app/bp;->f:Ljava/lang/CharSequence;

    iget-object v3, p1, Landroid/support/v4/app/bp;->a:Ljava/lang/CharSequence;

    invoke-static {p0, v0, v1, v2, v3}, Landroid/support/v4/app/cm;->a(Landroid/support/v4/app/bk;Ljava/lang/CharSequence;ZLjava/lang/CharSequence;Ljava/lang/CharSequence;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    instance-of v0, p1, Landroid/support/v4/app/br;

    if-eqz v0, :cond_2

    check-cast p1, Landroid/support/v4/app/br;

    iget-object v0, p1, Landroid/support/v4/app/br;->e:Ljava/lang/CharSequence;

    iget-boolean v1, p1, Landroid/support/v4/app/br;->g:Z

    iget-object v2, p1, Landroid/support/v4/app/br;->f:Ljava/lang/CharSequence;

    iget-object v3, p1, Landroid/support/v4/app/br;->a:Ljava/util/ArrayList;

    invoke-static {p0, v0, v1, v2, v3}, Landroid/support/v4/app/cm;->a(Landroid/support/v4/app/bk;Ljava/lang/CharSequence;ZLjava/lang/CharSequence;Ljava/util/ArrayList;)V

    goto :goto_0

    :cond_2
    instance-of v0, p1, Landroid/support/v4/app/bo;

    if-eqz v0, :cond_0

    check-cast p1, Landroid/support/v4/app/bo;

    iget-object v1, p1, Landroid/support/v4/app/bo;->e:Ljava/lang/CharSequence;

    iget-boolean v2, p1, Landroid/support/v4/app/bo;->g:Z

    iget-object v3, p1, Landroid/support/v4/app/bo;->f:Ljava/lang/CharSequence;

    iget-object v4, p1, Landroid/support/v4/app/bo;->a:Landroid/graphics/Bitmap;

    iget-object v5, p1, Landroid/support/v4/app/bo;->b:Landroid/graphics/Bitmap;

    iget-boolean v6, p1, Landroid/support/v4/app/bo;->c:Z

    move-object v0, p0

    invoke-static/range {v0 .. v6}, Landroid/support/v4/app/cm;->a(Landroid/support/v4/app/bk;Ljava/lang/CharSequence;ZLjava/lang/CharSequence;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Z)V

    goto :goto_0
.end method
