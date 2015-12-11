.class public final Lb/a/a/r;
.super Lb/a/a/a/e;
.source "SourceFile"

# interfaces
.implements Lb/a/a/aa;
.implements Ljava/io/Serializable;


# static fields
.field private static final b:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lb/a/a/m;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field final a:J

.field private final c:Lb/a/a/a;

.field private volatile transient d:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 96
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 98
    sput-object v0, Lb/a/a/r;->b:Ljava/util/Set;

    invoke-static {}, Lb/a/a/m;->f()Lb/a/a/m;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 99
    sget-object v0, Lb/a/a/r;->b:Ljava/util/Set;

    invoke-static {}, Lb/a/a/m;->g()Lb/a/a/m;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 100
    sget-object v0, Lb/a/a/r;->b:Ljava/util/Set;

    invoke-static {}, Lb/a/a/m;->i()Lb/a/a/m;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 101
    sget-object v0, Lb/a/a/r;->b:Ljava/util/Set;

    invoke-static {}, Lb/a/a/m;->h()Lb/a/a/m;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 102
    sget-object v0, Lb/a/a/r;->b:Ljava/util/Set;

    invoke-static {}, Lb/a/a/m;->j()Lb/a/a/m;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 103
    sget-object v0, Lb/a/a/r;->b:Ljava/util/Set;

    invoke-static {}, Lb/a/a/m;->k()Lb/a/a/m;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 105
    sget-object v0, Lb/a/a/r;->b:Ljava/util/Set;

    invoke-static {}, Lb/a/a/m;->l()Lb/a/a/m;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 106
    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    .line 267
    invoke-static {}, Lb/a/a/f;->a()J

    move-result-wide v0

    invoke-static {}, Lb/a/a/b/t;->M()Lb/a/a/b/t;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lb/a/a/r;-><init>(JLb/a/a/a;)V

    .line 268
    return-void
.end method

.method public constructor <init>(JLb/a/a/a;)V
    .locals 5

    .prologue
    .line 335
    invoke-direct {p0}, Lb/a/a/a/e;-><init>()V

    .line 336
    invoke-static {p3}, Lb/a/a/f;->a(Lb/a/a/a;)Lb/a/a/a;

    move-result-object v1

    .line 338
    invoke-virtual {v1}, Lb/a/a/a;->a()Lb/a/a/i;

    move-result-object v2

    sget-object v0, Lb/a/a/i;->a:Lb/a/a/i;

    if-nez v0, :cond_0

    invoke-static {}, Lb/a/a/i;->a()Lb/a/a/i;

    move-result-object v0

    :cond_0
    if-ne v0, v2, :cond_1

    .line 339
    :goto_0
    invoke-virtual {v1}, Lb/a/a/a;->b()Lb/a/a/a;

    move-result-object v0

    .line 340
    invoke-virtual {v0}, Lb/a/a/a;->u()Lb/a/a/c;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Lb/a/a/c;->d(J)J

    move-result-wide v2

    iput-wide v2, p0, Lb/a/a/r;->a:J

    .line 341
    iput-object v0, p0, Lb/a/a/r;->c:Lb/a/a/a;

    .line 342
    return-void

    .line 338
    :cond_1
    invoke-virtual {v2, p1, p2}, Lb/a/a/i;->d(J)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3, p1, p2}, Lb/a/a/i;->a(JJ)J

    move-result-wide p1

    goto :goto_0
.end method


# virtual methods
.method public final a(I)I
    .locals 4

    .prologue
    .line 524
    packed-switch p1, :pswitch_data_0

    .line 532
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Invalid index: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 526
    :pswitch_0
    iget-object v0, p0, Lb/a/a/r;->c:Lb/a/a/a;

    invoke-virtual {v0}, Lb/a/a/a;->E()Lb/a/a/c;

    move-result-object v0

    iget-wide v2, p0, Lb/a/a/r;->a:J

    invoke-virtual {v0, v2, v3}, Lb/a/a/c;->a(J)I

    move-result v0

    .line 530
    :goto_0
    return v0

    .line 528
    :pswitch_1
    iget-object v0, p0, Lb/a/a/r;->c:Lb/a/a/a;

    invoke-virtual {v0}, Lb/a/a/a;->C()Lb/a/a/c;

    move-result-object v0

    iget-wide v2, p0, Lb/a/a/r;->a:J

    invoke-virtual {v0, v2, v3}, Lb/a/a/c;->a(J)I

    move-result v0

    goto :goto_0

    .line 530
    :pswitch_2
    iget-object v0, p0, Lb/a/a/r;->c:Lb/a/a/a;

    invoke-virtual {v0}, Lb/a/a/a;->u()Lb/a/a/c;

    move-result-object v0

    iget-wide v2, p0, Lb/a/a/r;->a:J

    invoke-virtual {v0, v2, v3}, Lb/a/a/c;->a(J)I

    move-result v0

    goto :goto_0

    .line 524
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final a(Lb/a/a/aa;)I
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 676
    if-ne p0, p1, :cond_0

    move v0, v1

    .line 687
    :goto_0
    return v0

    .line 679
    :cond_0
    instance-of v0, p1, Lb/a/a/r;

    if-eqz v0, :cond_3

    move-object v0, p1

    .line 680
    check-cast v0, Lb/a/a/r;

    .line 681
    iget-object v2, p0, Lb/a/a/r;->c:Lb/a/a/a;

    iget-object v3, v0, Lb/a/a/r;->c:Lb/a/a/a;

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 682
    iget-wide v2, p0, Lb/a/a/r;->a:J

    iget-wide v4, v0, Lb/a/a/r;->a:J

    cmp-long v2, v2, v4

    if-gez v2, :cond_1

    const/4 v0, -0x1

    goto :goto_0

    :cond_1
    iget-wide v2, p0, Lb/a/a/r;->a:J

    iget-wide v4, v0, Lb/a/a/r;->a:J

    cmp-long v0, v2, v4

    if-nez v0, :cond_2

    move v0, v1

    goto :goto_0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0

    .line 687
    :cond_3
    invoke-super {p0, p1}, Lb/a/a/a/e;->a(Lb/a/a/aa;)I

    move-result v0

    goto :goto_0
.end method

.method public final a(Lb/a/a/d;)I
    .locals 4

    .prologue
    .line 552
    if-nez p1, :cond_0

    .line 553
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The DateTimeFieldType must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 555
    :cond_0
    invoke-virtual {p0, p1}, Lb/a/a/r;->b(Lb/a/a/d;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 556
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Field \'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\' is not supported"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 558
    :cond_1
    iget-object v0, p0, Lb/a/a/r;->c:Lb/a/a/a;

    invoke-virtual {p1, v0}, Lb/a/a/d;->a(Lb/a/a/a;)Lb/a/a/c;

    move-result-object v0

    iget-wide v2, p0, Lb/a/a/r;->a:J

    invoke-virtual {v0, v2, v3}, Lb/a/a/c;->a(J)I

    move-result v0

    return v0
.end method

.method public final a()Lb/a/a/a;
    .locals 1

    .prologue
    .line 619
    iget-object v0, p0, Lb/a/a/r;->c:Lb/a/a/a;

    return-object v0
.end method

.method protected final a(ILb/a/a/a;)Lb/a/a/c;
    .locals 3

    .prologue
    .line 499
    packed-switch p1, :pswitch_data_0

    .line 507
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Invalid index: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 501
    :pswitch_0
    invoke-virtual {p2}, Lb/a/a/a;->E()Lb/a/a/c;

    move-result-object v0

    .line 505
    :goto_0
    return-object v0

    .line 503
    :pswitch_1
    invoke-virtual {p2}, Lb/a/a/a;->C()Lb/a/a/c;

    move-result-object v0

    goto :goto_0

    .line 505
    :pswitch_2
    invoke-virtual {p2}, Lb/a/a/a;->u()Lb/a/a/c;

    move-result-object v0

    goto :goto_0

    .line 499
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final b(Lb/a/a/d;)Z
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 570
    if-nez p1, :cond_1

    .line 579
    :cond_0
    :goto_0
    return v0

    .line 573
    :cond_1
    invoke-virtual {p1}, Lb/a/a/d;->x()Lb/a/a/m;

    move-result-object v1

    .line 574
    sget-object v2, Lb/a/a/r;->b:Ljava/util/Set;

    invoke-interface {v2, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lb/a/a/r;->c:Lb/a/a/a;

    invoke-virtual {v1, v2}, Lb/a/a/m;->a(Lb/a/a/a;)Lb/a/a/l;

    move-result-object v1

    invoke-virtual {v1}, Lb/a/a/l;->d()J

    move-result-wide v2

    iget-object v1, p0, Lb/a/a/r;->c:Lb/a/a/a;

    invoke-virtual {v1}, Lb/a/a/a;->s()Lb/a/a/l;

    move-result-object v1

    invoke-virtual {v1}, Lb/a/a/l;->d()J

    move-result-wide v4

    cmp-long v1, v2, v4

    if-ltz v1, :cond_0

    .line 577
    :cond_2
    iget-object v0, p0, Lb/a/a/r;->c:Lb/a/a/a;

    invoke-virtual {p1, v0}, Lb/a/a/d;->a(Lb/a/a/a;)Lb/a/a/c;

    move-result-object v0

    invoke-virtual {v0}, Lb/a/a/c;->c()Z

    move-result v0

    goto :goto_0
.end method

.method public final synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 82
    check-cast p1, Lb/a/a/aa;

    invoke-virtual {p0, p1}, Lb/a/a/r;->a(Lb/a/a/aa;)I

    move-result v0

    return v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 6

    .prologue
    const/4 v1, 0x1

    .line 632
    if-ne p0, p1, :cond_0

    move v0, v1

    .line 641
    :goto_0
    return v0

    .line 635
    :cond_0
    instance-of v0, p1, Lb/a/a/r;

    if-eqz v0, :cond_2

    move-object v0, p1

    .line 636
    check-cast v0, Lb/a/a/r;

    .line 637
    iget-object v2, p0, Lb/a/a/r;->c:Lb/a/a/a;

    iget-object v3, v0, Lb/a/a/r;->c:Lb/a/a/a;

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 638
    iget-wide v2, p0, Lb/a/a/r;->a:J

    iget-wide v4, v0, Lb/a/a/r;->a:J

    cmp-long v0, v2, v4

    if-nez v0, :cond_1

    move v0, v1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 641
    :cond_2
    invoke-super {p0, p1}, Lb/a/a/a/e;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public final hashCode()I
    .locals 1

    .prologue
    .line 651
    iget v0, p0, Lb/a/a/r;->d:I

    .line 652
    if-nez v0, :cond_0

    .line 653
    invoke-super {p0}, Lb/a/a/a/e;->hashCode()I

    move-result v0

    iput v0, p0, Lb/a/a/r;->d:I

    .line 655
    :cond_0
    return v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 3
    .annotation runtime Lorg/joda/convert/ToString;
    .end annotation

    .prologue
    .line 1819
    invoke-static {}, Lb/a/a/d/aa;->d()Lb/a/a/d/d;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Lb/a/a/d/d;->a()Lb/a/a/d/x;

    move-result-object v2

    invoke-interface {v2}, Lb/a/a/d/x;->a()I

    move-result v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuffer;-><init>(I)V

    invoke-virtual {v0}, Lb/a/a/d/d;->a()Lb/a/a/d/x;

    move-result-object v2

    if-nez p0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The partial must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, v0, Lb/a/a/d/d;->c:Ljava/util/Locale;

    invoke-interface {v2, v1, p0, v0}, Lb/a/a/d/x;->a(Ljava/lang/StringBuffer;Lb/a/a/aa;Ljava/util/Locale;)V

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
