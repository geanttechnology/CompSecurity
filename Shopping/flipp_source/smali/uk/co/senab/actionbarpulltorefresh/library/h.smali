.class public final Luk/co/senab/actionbarpulltorefresh/library/h;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final h:I


# instance fields
.field a:Luk/co/senab/actionbarpulltorefresh/library/e;

.field b:I

.field c:Luk/co/senab/actionbarpulltorefresh/library/f;

.field d:F

.field e:Z

.field f:I

.field public g:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/t;->default_header:I

    sput v0, Luk/co/senab/actionbarpulltorefresh/library/h;->h:I

    return-void
.end method

.method constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/h;->a:Luk/co/senab/actionbarpulltorefresh/library/e;

    .line 38
    sget v0, Luk/co/senab/actionbarpulltorefresh/library/h;->h:I

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/h;->b:I

    .line 39
    iput-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/h;->c:Luk/co/senab/actionbarpulltorefresh/library/f;

    .line 40
    const/high16 v0, 0x3f000000    # 0.5f

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/h;->d:F

    .line 41
    const/4 v0, 0x0

    iput-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/h;->e:Z

    .line 42
    const/16 v0, 0x3e8

    iput v0, p0, Luk/co/senab/actionbarpulltorefresh/library/h;->f:I

    .line 52
    const/4 v0, 0x1

    iput-boolean v0, p0, Luk/co/senab/actionbarpulltorefresh/library/h;->g:Z

    .line 35
    return-void
.end method

.method public static a()Luk/co/senab/actionbarpulltorefresh/library/i;
    .locals 1

    .prologue
    .line 32
    new-instance v0, Luk/co/senab/actionbarpulltorefresh/library/i;

    invoke-direct {v0}, Luk/co/senab/actionbarpulltorefresh/library/i;-><init>()V

    return-object v0
.end method
