.class public final Lcom/wishabi/flipp/util/m;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final a:J

.field public b:I

.field public c:I

.field public d:I

.field public e:Ljava/lang/Object;


# direct methods
.method public constructor <init>(JI)V
    .locals 1

    .prologue
    const/4 v0, -0x1

    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput v0, p0, Lcom/wishabi/flipp/util/m;->b:I

    .line 17
    iput v0, p0, Lcom/wishabi/flipp/util/m;->c:I

    .line 26
    iput-wide p1, p0, Lcom/wishabi/flipp/util/m;->a:J

    .line 27
    iput p3, p0, Lcom/wishabi/flipp/util/m;->d:I

    .line 28
    return-void
.end method

.method public constructor <init>(JILjava/lang/Object;)V
    .locals 1

    .prologue
    const/4 v0, -0x1

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput v0, p0, Lcom/wishabi/flipp/util/m;->b:I

    .line 17
    iput v0, p0, Lcom/wishabi/flipp/util/m;->c:I

    .line 36
    iput-wide p1, p0, Lcom/wishabi/flipp/util/m;->a:J

    .line 37
    iput p3, p0, Lcom/wishabi/flipp/util/m;->d:I

    .line 38
    iput-object p4, p0, Lcom/wishabi/flipp/util/m;->e:Ljava/lang/Object;

    .line 39
    return-void
.end method
