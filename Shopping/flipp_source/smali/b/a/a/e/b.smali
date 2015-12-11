.class final Lb/a/a/e/b;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final a:J

.field public final b:Lb/a/a/i;

.field c:Lb/a/a/e/b;

.field d:Ljava/lang/String;

.field e:I

.field private f:I


# direct methods
.method constructor <init>(Lb/a/a/i;J)V
    .locals 2

    .prologue
    const/high16 v0, -0x80000000

    .line 180
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 177
    iput v0, p0, Lb/a/a/e/b;->e:I

    .line 178
    iput v0, p0, Lb/a/a/e/b;->f:I

    .line 181
    iput-wide p2, p0, Lb/a/a/e/b;->a:J

    .line 182
    iput-object p1, p0, Lb/a/a/e/b;->b:Lb/a/a/i;

    .line 183
    return-void
.end method
