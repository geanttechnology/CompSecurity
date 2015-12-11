.class public final Lcom/wishabi/flipp/app/c;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:J

.field b:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field c:Z

.field d:J

.field final e:Lcom/wishabi/flipp/app/d;


# direct methods
.method public constructor <init>(Lcom/wishabi/flipp/app/d;)V
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/app/c;-><init>(Lcom/wishabi/flipp/app/d;B)V

    .line 29
    return-void
.end method

.method private constructor <init>(Lcom/wishabi/flipp/app/d;B)V
    .locals 2

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    const-wide/32 v0, 0x77359400

    iput-wide v0, p0, Lcom/wishabi/flipp/app/c;->a:J

    .line 34
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/app/c;->b:Ljava/lang/ref/WeakReference;

    .line 35
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/c;->c:Z

    .line 36
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/wishabi/flipp/app/c;->d:J

    .line 38
    iput-object p1, p0, Lcom/wishabi/flipp/app/c;->e:Lcom/wishabi/flipp/app/d;

    .line 39
    return-void
.end method
