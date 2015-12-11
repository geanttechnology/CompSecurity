.class public abstract Lb/a/a/i;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field public static final a:Lb/a/a/i;

.field public static b:Lb/a/a/e/j;

.field private static d:Lb/a/a/e/k;

.field private static e:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static volatile f:Lb/a/a/i;

.field private static g:Lb/a/a/d/d;

.field private static h:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/ref/SoftReference",
            "<",
            "Lb/a/a/i;",
            ">;>;"
        }
    .end annotation
.end field

.field private static i:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public final c:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 94
    new-instance v0, Lb/a/a/e/i;

    const-string v1, "UTC"

    const-string v2, "UTC"

    invoke-direct {v0, v1, v2, v3, v3}, Lb/a/a/e/i;-><init>(Ljava/lang/String;Ljava/lang/String;II)V

    sput-object v0, Lb/a/a/i;->a:Lb/a/a/i;

    .line 116
    invoke-static {}, Lb/a/a/i;->d()Lb/a/a/e/k;

    move-result-object v0

    invoke-interface {v0}, Lb/a/a/e/k;->a()Ljava/util/Set;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/Set;->size()I

    move-result v2

    if-nez v2, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The provider doesn\'t have any available ids"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    const-string v2, "UTC"

    invoke-interface {v1, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The provider doesn\'t support UTC"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    sget-object v2, Lb/a/a/i;->a:Lb/a/a/i;

    const-string v3, "UTC"

    invoke-interface {v0, v3}, Lb/a/a/e/k;->a(Ljava/lang/String;)Lb/a/a/i;

    move-result-object v3

    invoke-virtual {v2, v3}, Lb/a/a/i;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid UTC zone provided"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    sput-object v0, Lb/a/a/i;->d:Lb/a/a/e/k;

    sput-object v1, Lb/a/a/i;->e:Ljava/util/Set;

    .line 117
    invoke-static {}, Lb/a/a/i;->e()Lb/a/a/e/j;

    move-result-object v0

    sput-object v0, Lb/a/a/i;->b:Lb/a/a/e/j;

    .line 118
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 718
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 719
    if-nez p1, :cond_0

    .line 720
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Id must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 722
    :cond_0
    iput-object p1, p0, Lb/a/a/i;->c:Ljava/lang/String;

    .line 723
    return-void
.end method

.method public static a()Lb/a/a/i;
    .locals 3

    .prologue
    .line 134
    sget-object v0, Lb/a/a/i;->f:Lb/a/a/i;

    .line 135
    if-nez v0, :cond_4

    .line 136
    const-class v1, Lb/a/a/i;

    monitor-enter v1

    .line 137
    :try_start_0
    sget-object v0, Lb/a/a/i;->f:Lb/a/a/i;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 138
    if-nez v0, :cond_3

    .line 139
    const/4 v0, 0x0

    .line 142
    :try_start_1
    const-string v2, "user.timezone"

    invoke-static {v2}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 143
    if-eqz v2, :cond_0

    .line 144
    invoke-static {v2}, Lb/a/a/i;->a(Ljava/lang/String;)Lb/a/a/i;
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    .line 149
    :cond_0
    :goto_0
    if-nez v0, :cond_1

    .line 150
    :try_start_2
    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v2

    invoke-static {v2}, Lb/a/a/i;->a(Ljava/util/TimeZone;)Lb/a/a/i;
    :try_end_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v0

    .line 155
    :cond_1
    :goto_1
    if-nez v0, :cond_2

    .line 156
    :try_start_3
    sget-object v0, Lb/a/a/i;->a:Lb/a/a/i;

    .line 158
    :cond_2
    sput-object v0, Lb/a/a/i;->f:Lb/a/a/i;

    .line 160
    :cond_3
    monitor-exit v1

    .line 162
    :cond_4
    return-object v0

    .line 160
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v0

    :catch_0
    move-exception v2

    goto :goto_1

    :catch_1
    move-exception v2

    goto :goto_0
.end method

.method public static a(I)Lb/a/a/i;
    .locals 3

    .prologue
    .line 307
    const v0, -0x5265bff

    if-lt p0, v0, :cond_0

    const v0, 0x5265bff

    if-le p0, v0, :cond_1

    .line 308
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Millis out of range: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 310
    :cond_1
    invoke-static {p0}, Lb/a/a/i;->b(I)Ljava/lang/String;

    move-result-object v0

    .line 311
    invoke-static {v0, p0}, Lb/a/a/i;->a(Ljava/lang/String;I)Lb/a/a/i;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;)Lb/a/a/i;
    .locals 6
    .annotation runtime Lorg/joda/convert/FromString;
    .end annotation

    .prologue
    .line 205
    if-nez p0, :cond_1

    .line 206
    invoke-static {}, Lb/a/a/i;->a()Lb/a/a/i;

    move-result-object v0

    .line 221
    :cond_0
    :goto_0
    return-object v0

    .line 208
    :cond_1
    const-string v0, "UTC"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 209
    sget-object v0, Lb/a/a/i;->a:Lb/a/a/i;

    goto :goto_0

    .line 211
    :cond_2
    sget-object v0, Lb/a/a/i;->d:Lb/a/a/e/k;

    invoke-interface {v0, p0}, Lb/a/a/e/k;->a(Ljava/lang/String;)Lb/a/a/i;

    move-result-object v0

    .line 212
    if-nez v0, :cond_0

    .line 215
    const-string v0, "+"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    const-string v0, "-"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 216
    :cond_3
    invoke-static {p0}, Lb/a/a/i;->c(Ljava/lang/String;)I

    move-result v0

    .line 217
    int-to-long v2, v0

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_4

    .line 218
    sget-object v0, Lb/a/a/i;->a:Lb/a/a/i;

    goto :goto_0

    .line 220
    :cond_4
    invoke-static {v0}, Lb/a/a/i;->b(I)Ljava/lang/String;

    move-result-object v1

    .line 221
    invoke-static {v1, v0}, Lb/a/a/i;->a(Ljava/lang/String;I)Lb/a/a/i;

    move-result-object v0

    goto :goto_0

    .line 224
    :cond_5
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "The datetime zone id \'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\' is not recognised"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static declared-synchronized a(Ljava/lang/String;I)Lb/a/a/i;
    .locals 4

    .prologue
    .line 377
    const-class v1, Lb/a/a/i;

    monitor-enter v1

    if-nez p1, :cond_1

    .line 378
    :try_start_0
    sget-object v0, Lb/a/a/i;->a:Lb/a/a/i;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 393
    :cond_0
    :goto_0
    monitor-exit v1

    return-object v0

    .line 380
    :cond_1
    :try_start_1
    sget-object v0, Lb/a/a/i;->h:Ljava/util/Map;

    if-nez v0, :cond_2

    .line 381
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lb/a/a/i;->h:Ljava/util/Map;

    .line 384
    :cond_2
    sget-object v0, Lb/a/a/i;->h:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/Reference;

    .line 385
    if-eqz v0, :cond_3

    .line 386
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lb/a/a/i;

    .line 387
    if-nez v0, :cond_0

    .line 391
    :cond_3
    new-instance v0, Lb/a/a/e/i;

    const/4 v2, 0x0

    invoke-direct {v0, p0, v2, p1, p1}, Lb/a/a/e/i;-><init>(Ljava/lang/String;Ljava/lang/String;II)V

    .line 392
    sget-object v2, Lb/a/a/i;->h:Ljava/util/Map;

    new-instance v3, Ljava/lang/ref/SoftReference;

    invoke-direct {v3, v0}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    invoke-interface {v2, p0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 377
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static a(Ljava/util/TimeZone;)Lb/a/a/i;
    .locals 6

    .prologue
    .line 330
    if-nez p0, :cond_1

    .line 331
    invoke-static {}, Lb/a/a/i;->a()Lb/a/a/i;

    move-result-object v0

    .line 361
    :cond_0
    :goto_0
    return-object v0

    .line 333
    :cond_1
    invoke-virtual {p0}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v1

    .line 334
    const-string v0, "UTC"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 335
    sget-object v0, Lb/a/a/i;->a:Lb/a/a/i;

    goto :goto_0

    .line 339
    :cond_2
    const/4 v0, 0x0

    .line 340
    invoke-static {v1}, Lb/a/a/i;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 341
    if-eqz v2, :cond_3

    .line 342
    sget-object v0, Lb/a/a/i;->d:Lb/a/a/e/k;

    invoke-interface {v0, v2}, Lb/a/a/e/k;->a(Ljava/lang/String;)Lb/a/a/i;

    move-result-object v0

    .line 344
    :cond_3
    if-nez v0, :cond_4

    .line 345
    sget-object v0, Lb/a/a/i;->d:Lb/a/a/e/k;

    invoke-interface {v0, v1}, Lb/a/a/e/k;->a(Ljava/lang/String;)Lb/a/a/i;

    move-result-object v0

    .line 347
    :cond_4
    if-nez v0, :cond_0

    .line 352
    if-nez v2, :cond_7

    .line 353
    invoke-virtual {p0}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v0

    .line 354
    const-string v2, "GMT+"

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    const-string v2, "GMT-"

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 355
    :cond_5
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 356
    invoke-static {v0}, Lb/a/a/i;->c(Ljava/lang/String;)I

    move-result v0

    .line 357
    int-to-long v2, v0

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_6

    .line 358
    sget-object v0, Lb/a/a/i;->a:Lb/a/a/i;

    goto :goto_0

    .line 360
    :cond_6
    invoke-static {v0}, Lb/a/a/i;->b(I)Ljava/lang/String;

    move-result-object v1

    .line 361
    invoke-static {v1, v0}, Lb/a/a/i;->a(Ljava/lang/String;I)Lb/a/a/i;

    move-result-object v0

    goto :goto_0

    .line 365
    :cond_7
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "The datetime zone id \'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\' is not recognised"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static b(I)Ljava/lang/String;
    .locals 6

    .prologue
    const v2, 0x36ee80

    const v5, 0xea60

    const/16 v4, 0x3a

    const/4 v3, 0x2

    .line 660
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 661
    if-ltz p0, :cond_0

    .line 662
    const/16 v1, 0x2b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 668
    :goto_0
    div-int v1, p0, v2

    .line 669
    invoke-static {v0, v1, v3}, Lb/a/a/d/y;->a(Ljava/lang/StringBuffer;II)V

    .line 670
    mul-int/2addr v1, v2

    sub-int v1, p0, v1

    .line 672
    div-int v2, v1, v5

    .line 673
    invoke-virtual {v0, v4}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 674
    invoke-static {v0, v2, v3}, Lb/a/a/d/y;->a(Ljava/lang/StringBuffer;II)V

    .line 675
    mul-int/2addr v2, v5

    sub-int/2addr v1, v2

    .line 676
    if-nez v1, :cond_1

    .line 677
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    .line 690
    :goto_1
    return-object v0

    .line 664
    :cond_0
    const/16 v1, 0x2d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 665
    neg-int p0, p0

    goto :goto_0

    .line 680
    :cond_1
    div-int/lit16 v2, v1, 0x3e8

    .line 681
    invoke-virtual {v0, v4}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 682
    invoke-static {v0, v2, v3}, Lb/a/a/d/y;->a(Ljava/lang/StringBuffer;II)V

    .line 683
    mul-int/lit16 v2, v2, 0x3e8

    sub-int/2addr v1, v2

    .line 684
    if-nez v1, :cond_2

    .line 685
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 688
    :cond_2
    const/16 v2, 0x2e

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 689
    const/4 v2, 0x3

    invoke-static {v0, v1, v2}, Lb/a/a/d/y;->a(Ljava/lang/StringBuffer;II)V

    .line 690
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method private static declared-synchronized b(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 587
    const-class v1, Lb/a/a/i;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lb/a/a/i;->i:Ljava/util/Map;

    .line 588
    if-nez v0, :cond_0

    .line 590
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 591
    const-string v2, "GMT"

    const-string v3, "UTC"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 592
    const-string v2, "WET"

    const-string v3, "WET"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 593
    const-string v2, "CET"

    const-string v3, "CET"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 594
    const-string v2, "MET"

    const-string v3, "CET"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 595
    const-string v2, "ECT"

    const-string v3, "CET"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 596
    const-string v2, "EET"

    const-string v3, "EET"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 597
    const-string v2, "MIT"

    const-string v3, "Pacific/Apia"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 598
    const-string v2, "HST"

    const-string v3, "Pacific/Honolulu"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 599
    const-string v2, "AST"

    const-string v3, "America/Anchorage"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 600
    const-string v2, "PST"

    const-string v3, "America/Los_Angeles"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 601
    const-string v2, "MST"

    const-string v3, "America/Denver"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 602
    const-string v2, "PNT"

    const-string v3, "America/Phoenix"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 603
    const-string v2, "CST"

    const-string v3, "America/Chicago"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 604
    const-string v2, "EST"

    const-string v3, "America/New_York"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 605
    const-string v2, "IET"

    const-string v3, "America/Indiana/Indianapolis"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 606
    const-string v2, "PRT"

    const-string v3, "America/Puerto_Rico"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 607
    const-string v2, "CNT"

    const-string v3, "America/St_Johns"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 608
    const-string v2, "AGT"

    const-string v3, "America/Argentina/Buenos_Aires"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 609
    const-string v2, "BET"

    const-string v3, "America/Sao_Paulo"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 610
    const-string v2, "ART"

    const-string v3, "Africa/Cairo"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 611
    const-string v2, "CAT"

    const-string v3, "Africa/Harare"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 612
    const-string v2, "EAT"

    const-string v3, "Africa/Addis_Ababa"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 613
    const-string v2, "NET"

    const-string v3, "Asia/Yerevan"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 614
    const-string v2, "PLT"

    const-string v3, "Asia/Karachi"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 615
    const-string v2, "IST"

    const-string v3, "Asia/Kolkata"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 616
    const-string v2, "BST"

    const-string v3, "Asia/Dhaka"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 617
    const-string v2, "VST"

    const-string v3, "Asia/Ho_Chi_Minh"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 618
    const-string v2, "CTT"

    const-string v3, "Asia/Shanghai"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 619
    const-string v2, "JST"

    const-string v3, "Asia/Tokyo"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 620
    const-string v2, "ACT"

    const-string v3, "Australia/Darwin"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 621
    const-string v2, "AET"

    const-string v3, "Australia/Sydney"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 622
    const-string v2, "SST"

    const-string v3, "Pacific/Guadalcanal"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 623
    const-string v2, "NST"

    const-string v3, "Pacific/Auckland"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 624
    sput-object v0, Lb/a/a/i;->i:Ljava/util/Map;

    .line 626
    :cond_0
    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 587
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static b()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 402
    sget-object v0, Lb/a/a/i;->e:Ljava/util/Set;

    return-object v0
.end method

.method private static c(Ljava/lang/String;)I
    .locals 9

    .prologue
    .line 632
    new-instance v5, Lb/a/a/j;

    invoke-direct {v5}, Lb/a/a/j;-><init>()V

    .line 647
    invoke-static {}, Lb/a/a/i;->f()Lb/a/a/d/d;

    move-result-object v8

    iget-object v0, v8, Lb/a/a/d/d;->e:Lb/a/a/a;

    if-ne v0, v5, :cond_0

    move-object v0, v8

    :goto_0
    invoke-virtual {v0}, Lb/a/a/d/d;->b()Lb/a/a/d/t;

    move-result-object v1

    iget-object v2, v0, Lb/a/a/d/d;->e:Lb/a/a/a;

    invoke-virtual {v0, v2}, Lb/a/a/d/d;->a(Lb/a/a/a;)Lb/a/a/a;

    move-result-object v2

    new-instance v3, Lb/a/a/d/u;

    iget-object v4, v0, Lb/a/a/d/d;->c:Ljava/util/Locale;

    iget-object v5, v0, Lb/a/a/d/d;->g:Ljava/lang/Integer;

    iget v0, v0, Lb/a/a/d/d;->h:I

    invoke-direct {v3, v2, v4, v5, v0}, Lb/a/a/d/u;-><init>(Lb/a/a/a;Ljava/util/Locale;Ljava/lang/Integer;I)V

    const/4 v0, 0x0

    invoke-interface {v1, v3, p0, v0}, Lb/a/a/d/t;->a(Lb/a/a/d/u;Ljava/lang/String;I)I

    move-result v0

    if-ltz v0, :cond_1

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    if-lt v0, v1, :cond_2

    invoke-virtual {v3, p0}, Lb/a/a/d/u;->a(Ljava/lang/String;)J

    move-result-wide v0

    long-to-int v0, v0

    neg-int v0, v0

    return v0

    :cond_0
    new-instance v0, Lb/a/a/d/d;

    iget-object v1, v8, Lb/a/a/d/d;->a:Lb/a/a/d/x;

    iget-object v2, v8, Lb/a/a/d/d;->b:Lb/a/a/d/t;

    iget-object v3, v8, Lb/a/a/d/d;->c:Ljava/util/Locale;

    iget-boolean v4, v8, Lb/a/a/d/d;->d:Z

    iget-object v6, v8, Lb/a/a/d/d;->f:Lb/a/a/i;

    iget-object v7, v8, Lb/a/a/d/d;->g:Ljava/lang/Integer;

    iget v8, v8, Lb/a/a/d/d;->h:I

    invoke-direct/range {v0 .. v8}, Lb/a/a/d/d;-><init>(Lb/a/a/d/x;Lb/a/a/d/t;Ljava/util/Locale;ZLb/a/a/a;Lb/a/a/i;Ljava/lang/Integer;I)V

    goto :goto_0

    :cond_1
    xor-int/lit8 v0, v0, -0x1

    :cond_2
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-static {p0, v0}, Lb/a/a/d/y;->b(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private static d()Lb/a/a/e/k;
    .locals 4

    .prologue
    .line 471
    const/4 v1, 0x0

    .line 474
    :try_start_0
    const-string v0, "org.joda.time.DateTimeZone.Provider"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    .line 476
    if-eqz v0, :cond_0

    .line 478
    :try_start_1
    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lb/a/a/e/k;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_1

    move-object v1, v0

    .line 488
    :cond_0
    :goto_0
    if-nez v1, :cond_2

    .line 490
    :try_start_2
    new-instance v0, Lb/a/a/e/m;

    const-string v2, "org/joda/time/tz/data"

    invoke-direct {v0, v2}, Lb/a/a/e/m;-><init>(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 497
    :goto_1
    if-nez v0, :cond_1

    .line 498
    new-instance v0, Lb/a/a/e/l;

    invoke-direct {v0}, Lb/a/a/e/l;-><init>()V

    .line 501
    :cond_1
    return-object v0

    .line 479
    :catch_0
    move-exception v0

    .line 480
    :try_start_3
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    .line 481
    invoke-virtual {v2}, Ljava/lang/Thread;->getThreadGroup()Ljava/lang/ThreadGroup;

    move-result-object v3

    invoke-virtual {v3, v2, v0}, Ljava/lang/ThreadGroup;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    :try_end_3
    .catch Ljava/lang/SecurityException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    :catch_1
    move-exception v0

    goto :goto_0

    .line 491
    :catch_2
    move-exception v0

    .line 492
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    .line 493
    invoke-virtual {v2}, Ljava/lang/Thread;->getThreadGroup()Ljava/lang/ThreadGroup;

    move-result-object v3

    invoke-virtual {v3, v2, v0}, Ljava/lang/ThreadGroup;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    :cond_2
    move-object v0, v1

    goto :goto_1
.end method

.method private static e()Lb/a/a/e/j;
    .locals 4

    .prologue
    .line 557
    const/4 v1, 0x0

    .line 559
    :try_start_0
    const-string v0, "org.joda.time.DateTimeZone.NameProvider"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    .line 560
    if-eqz v0, :cond_1

    .line 562
    :try_start_1
    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lb/a/a/e/j;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_1

    .line 572
    :goto_0
    if-nez v0, :cond_0

    .line 573
    new-instance v0, Lb/a/a/e/h;

    invoke-direct {v0}, Lb/a/a/e/h;-><init>()V

    .line 576
    :cond_0
    return-object v0

    .line 563
    :catch_0
    move-exception v0

    .line 564
    :try_start_2
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    .line 565
    invoke-virtual {v2}, Ljava/lang/Thread;->getThreadGroup()Ljava/lang/ThreadGroup;

    move-result-object v3

    invoke-virtual {v3, v2, v0}, Ljava/lang/ThreadGroup;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    :try_end_2
    .catch Ljava/lang/SecurityException; {:try_start_2 .. :try_end_2} :catch_1

    :cond_1
    move-object v0, v1

    .line 570
    goto :goto_0

    :catch_1
    move-exception v0

    move-object v0, v1

    goto :goto_0
.end method

.method private static declared-synchronized f()Lb/a/a/d/d;
    .locals 5

    .prologue
    .line 699
    const-class v1, Lb/a/a/i;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lb/a/a/i;->g:Lb/a/a/d/d;

    if-nez v0, :cond_0

    .line 700
    new-instance v0, Lb/a/a/d/e;

    invoke-direct {v0}, Lb/a/a/d/e;-><init>()V

    const/4 v2, 0x0

    const/4 v3, 0x1

    const/4 v4, 0x4

    invoke-virtual {v0, v2, v3, v4}, Lb/a/a/d/e;->a(Ljava/lang/String;ZI)Lb/a/a/d/e;

    move-result-object v0

    invoke-virtual {v0}, Lb/a/a/d/e;->a()Lb/a/a/d/d;

    move-result-object v0

    sput-object v0, Lb/a/a/i;->g:Lb/a/a/d/d;

    .line 704
    :cond_0
    sget-object v0, Lb/a/a/i;->g:Lb/a/a/d/d;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 699
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public final a(JJ)J
    .locals 9

    .prologue
    .line 980
    invoke-virtual {p0, p3, p4}, Lb/a/a/i;->b(J)I

    move-result v2

    .line 981
    int-to-long v0, v2

    sub-long v0, p1, v0

    .line 982
    invoke-virtual {p0, v0, v1}, Lb/a/a/i;->b(J)I

    move-result v3

    .line 983
    if-ne v3, v2, :cond_1

    .line 986
    :cond_0
    return-wide v0

    :cond_1
    invoke-virtual {p0, p1, p2}, Lb/a/a/i;->b(J)I

    move-result v2

    int-to-long v0, v2

    sub-long v0, p1, v0

    invoke-virtual {p0, v0, v1}, Lb/a/a/i;->b(J)I

    move-result v3

    if-eq v2, v3, :cond_4

    if-gez v2, :cond_4

    int-to-long v0, v2

    sub-long v0, p1, v0

    invoke-virtual {p0, v0, v1}, Lb/a/a/i;->e(J)J

    move-result-wide v0

    int-to-long v4, v2

    sub-long v4, p1, v4

    cmp-long v4, v0, v4

    if-nez v4, :cond_2

    const-wide v0, 0x7fffffffffffffffL

    :cond_2
    int-to-long v4, v3

    sub-long v4, p1, v4

    invoke-virtual {p0, v4, v5}, Lb/a/a/i;->e(J)J

    move-result-wide v4

    int-to-long v6, v3

    sub-long v6, p1, v6

    cmp-long v6, v4, v6

    if-nez v6, :cond_3

    const-wide v4, 0x7fffffffffffffffL

    :cond_3
    cmp-long v0, v0, v4

    if-eqz v0, :cond_4

    :goto_0
    int-to-long v0, v2

    sub-long v0, p1, v0

    xor-long v4, p1, v0

    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-gez v3, :cond_0

    int-to-long v2, v2

    xor-long/2addr v2, p1

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-gez v2, :cond_0

    new-instance v0, Ljava/lang/ArithmeticException;

    const-string v1, "Subtracting time zone offset caused overflow"

    invoke-direct {v0, v1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_4
    move v2, v3

    goto :goto_0
.end method

.method public abstract a(J)Ljava/lang/String;
.end method

.method public abstract b(J)I
.end method

.method public c(J)I
    .locals 9

    .prologue
    .line 911
    invoke-virtual {p0, p1, p2}, Lb/a/a/i;->b(J)I

    move-result v0

    .line 913
    int-to-long v2, v0

    sub-long v4, p1, v2

    .line 914
    invoke-virtual {p0, v4, v5}, Lb/a/a/i;->b(J)I

    move-result v2

    .line 916
    if-eq v0, v2, :cond_0

    .line 919
    sub-int v1, v0, v2

    if-gez v1, :cond_1

    .line 923
    invoke-virtual {p0, v4, v5}, Lb/a/a/i;->e(J)J

    move-result-wide v4

    .line 924
    int-to-long v6, v2

    sub-long v6, p1, v6

    invoke-virtual {p0, v6, v7}, Lb/a/a/i;->e(J)J

    move-result-wide v6

    .line 925
    cmp-long v1, v4, v6

    if-eqz v1, :cond_1

    .line 939
    :goto_0
    return v0

    .line 929
    :cond_0
    if-ltz v0, :cond_1

    .line 930
    invoke-virtual {p0, v4, v5}, Lb/a/a/i;->f(J)J

    move-result-wide v6

    .line 931
    cmp-long v1, v6, v4

    if-gez v1, :cond_1

    .line 932
    invoke-virtual {p0, v6, v7}, Lb/a/a/i;->b(J)I

    move-result v1

    .line 933
    sub-int v0, v1, v0

    .line 934
    sub-long/2addr v4, v6

    int-to-long v6, v0

    cmp-long v0, v4, v6

    if-gtz v0, :cond_1

    move v0, v1

    .line 935
    goto :goto_0

    :cond_1
    move v0, v2

    .line 939
    goto :goto_0
.end method

.method public abstract c()Z
.end method

.method public final d(J)J
    .locals 9

    .prologue
    const-wide/16 v6, 0x0

    .line 953
    invoke-virtual {p0, p1, p2}, Lb/a/a/i;->b(J)I

    move-result v0

    .line 954
    int-to-long v2, v0

    add-long/2addr v2, p1

    .line 956
    xor-long v4, p1, v2

    cmp-long v1, v4, v6

    if-gez v1, :cond_0

    int-to-long v0, v0

    xor-long/2addr v0, p1

    cmp-long v0, v0, v6

    if-ltz v0, :cond_0

    .line 957
    new-instance v0, Ljava/lang/ArithmeticException;

    const-string v1, "Adding time zone offset caused overflow"

    invoke-direct {v0, v1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 959
    :cond_0
    return-wide v2
.end method

.method public abstract e(J)J
.end method

.method public abstract equals(Ljava/lang/Object;)Z
.end method

.method public abstract f(J)J
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 1277
    iget-object v0, p0, Lb/a/a/i;->c:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    add-int/lit8 v0, v0, 0x39

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1285
    iget-object v0, p0, Lb/a/a/i;->c:Ljava/lang/String;

    return-object v0
.end method
