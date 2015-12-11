.class public final Lbf;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Lao;

.field private final b:Lag;

.field private final c:I

.field private d:J

.field private e:I


# direct methods
.method public constructor <init>(Lao;Lag;I)V
    .locals 2

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lbf;->a:Lao;

    .line 20
    const v0, 0xea60

    iput v0, p0, Lbf;->c:I

    .line 21
    iput-object p2, p0, Lbf;->b:Lag;

    .line 22
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lbf;->d:J

    .line 23
    const/4 v0, 0x0

    iput v0, p0, Lbf;->e:I

    .line 24
    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 6

    .prologue
    .line 27
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 28
    iget-wide v2, p0, Lbf;->d:J

    iget v4, p0, Lbf;->c:I

    int-to-long v4, v4

    add-long/2addr v2, v4

    cmp-long v2, v0, v2

    if-lez v2, :cond_1

    .line 29
    iget-object v2, p0, Lbf;->b:Lag;

    iget v3, p0, Lbf;->e:I

    invoke-virtual {v2, p1, p2, v3}, Lag;->a(Ljava/lang/String;Ljava/lang/Throwable;I)Lorg/json/JSONObject;

    move-result-object v2

    .line 30
    if-eqz v2, :cond_0

    .line 31
    iget-object v3, p0, Lbf;->a:Lao;

    invoke-virtual {v3, v2}, Lao;->b(Lorg/json/JSONObject;)V

    .line 32
    const/4 v2, 0x0

    iput v2, p0, Lbf;->e:I

    .line 33
    iput-wide v0, p0, Lbf;->d:J

    .line 38
    :cond_0
    :goto_0
    return-void

    .line 36
    :cond_1
    iget v0, p0, Lbf;->e:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lbf;->e:I

    goto :goto_0
.end method
