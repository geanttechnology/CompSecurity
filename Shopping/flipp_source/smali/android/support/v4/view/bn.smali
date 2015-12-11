.class public final Landroid/support/v4/view/bn;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static final a:Landroid/support/v4/view/br;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 128
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 129
    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 130
    new-instance v0, Landroid/support/v4/view/bo;

    invoke-direct {v0}, Landroid/support/v4/view/bo;-><init>()V

    sput-object v0, Landroid/support/v4/view/bn;->a:Landroid/support/v4/view/br;

    .line 140
    :goto_0
    return-void

    .line 131
    :cond_0
    const/16 v1, 0x12

    if-lt v0, v1, :cond_1

    .line 132
    new-instance v0, Landroid/support/v4/view/bs;

    invoke-direct {v0}, Landroid/support/v4/view/bs;-><init>()V

    sput-object v0, Landroid/support/v4/view/bn;->a:Landroid/support/v4/view/br;

    goto :goto_0

    .line 133
    :cond_1
    const/16 v1, 0xe

    if-lt v0, v1, :cond_2

    .line 134
    new-instance v0, Landroid/support/v4/view/bq;

    invoke-direct {v0}, Landroid/support/v4/view/bq;-><init>()V

    sput-object v0, Landroid/support/v4/view/bn;->a:Landroid/support/v4/view/br;

    goto :goto_0

    .line 135
    :cond_2
    const/16 v1, 0xb

    if-lt v0, v1, :cond_3

    .line 136
    new-instance v0, Landroid/support/v4/view/bp;

    invoke-direct {v0}, Landroid/support/v4/view/bp;-><init>()V

    sput-object v0, Landroid/support/v4/view/bn;->a:Landroid/support/v4/view/br;

    goto :goto_0

    .line 138
    :cond_3
    new-instance v0, Landroid/support/v4/view/bt;

    invoke-direct {v0}, Landroid/support/v4/view/bt;-><init>()V

    sput-object v0, Landroid/support/v4/view/bn;->a:Landroid/support/v4/view/br;

    goto :goto_0
.end method

.method public static a(Landroid/view/ViewGroup;)V
    .locals 1

    .prologue
    .line 186
    sget-object v0, Landroid/support/v4/view/bn;->a:Landroid/support/v4/view/br;

    invoke-interface {v0, p0}, Landroid/support/v4/view/br;->a(Landroid/view/ViewGroup;)V

    .line 187
    return-void
.end method
