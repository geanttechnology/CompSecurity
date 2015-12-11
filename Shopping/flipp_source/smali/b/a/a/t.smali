.class public final Lb/a/a/t;
.super Lb/a/a/a/d;
.source "SourceFile"

# interfaces
.implements Lb/a/a/w;
.implements Ljava/io/Serializable;
.implements Ljava/lang/Cloneable;


# instance fields
.field private c:Lb/a/a/c;

.field private d:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 172
    invoke-direct {p0}, Lb/a/a/a/d;-><init>()V

    .line 173
    return-void
.end method

.method public constructor <init>(Lb/a/a/i;)V
    .locals 1

    .prologue
    .line 223
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lb/a/a/a/d;-><init>(Lb/a/a/i;B)V

    .line 224
    return-void
.end method


# virtual methods
.method public final a(J)V
    .locals 1

    .prologue
    .line 454
    iget v0, p0, Lb/a/a/t;->d:I

    packed-switch v0, :pswitch_data_0

    .line 474
    :goto_0
    :pswitch_0
    invoke-super {p0, p1, p2}, Lb/a/a/a/d;->a(J)V

    .line 475
    return-void

    .line 458
    :pswitch_1
    iget-object v0, p0, Lb/a/a/t;->c:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->d(J)J

    move-result-wide p1

    goto :goto_0

    .line 461
    :pswitch_2
    iget-object v0, p0, Lb/a/a/t;->c:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->e(J)J

    move-result-wide p1

    goto :goto_0

    .line 464
    :pswitch_3
    iget-object v0, p0, Lb/a/a/t;->c:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->f(J)J

    move-result-wide p1

    goto :goto_0

    .line 467
    :pswitch_4
    iget-object v0, p0, Lb/a/a/t;->c:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->g(J)J

    move-result-wide p1

    goto :goto_0

    .line 470
    :pswitch_5
    iget-object v0, p0, Lb/a/a/t;->c:Lb/a/a/c;

    invoke-virtual {v0, p1, p2}, Lb/a/a/c;->h(J)J

    move-result-wide p1

    goto :goto_0

    .line 454
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public final clone()Ljava/lang/Object;
    .locals 2

    .prologue
    .line 1217
    :try_start_0
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 1219
    :catch_0
    move-exception v0

    new-instance v0, Ljava/lang/InternalError;

    const-string v1, "Clone error"

    invoke-direct {v0, v1}, Ljava/lang/InternalError;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 1
    .annotation runtime Lorg/joda/convert/ToString;
    .end annotation

    .prologue
    .line 1230
    invoke-static {}, Lb/a/a/d/aa;->b()Lb/a/a/d/d;

    move-result-object v0

    invoke-virtual {v0, p0}, Lb/a/a/d/d;->a(Lb/a/a/z;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
