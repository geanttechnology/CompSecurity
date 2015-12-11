.class final Lb/a/a/d/c;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lb/a/a/d/t;
.implements Lb/a/a/d/x;


# static fields
.field private static final a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lb/a/a/d/d;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final b:I

.field private final c:I

.field private final d:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 791
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lb/a/a/d/c;->a:Ljava/util/Map;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    .prologue
    .line 798
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 799
    const/4 v0, 0x3

    iput v0, p0, Lb/a/a/d/c;->b:I

    .line 800
    const/4 v0, 0x4

    iput v0, p0, Lb/a/a/d/c;->c:I

    .line 801
    const/4 v0, 0x0

    iput v0, p0, Lb/a/a/d/c;->d:I

    .line 802
    return-void
.end method

.method private a(Ljava/util/Locale;)Lb/a/a/d/d;
    .locals 4

    .prologue
    .line 842
    if-nez p1, :cond_0

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object p1

    .line 843
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v1, p0, Lb/a/a/d/c;->d:I

    iget v2, p0, Lb/a/a/d/c;->b:I

    shl-int/lit8 v2, v2, 0x4

    add-int/2addr v1, v2

    iget v2, p0, Lb/a/a/d/c;->c:I

    shl-int/lit8 v2, v2, 0x8

    add-int/2addr v1, v2

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 844
    sget-object v2, Lb/a/a/d/c;->a:Ljava/util/Map;

    monitor-enter v2

    .line 846
    :try_start_0
    sget-object v0, Lb/a/a/d/c;->a:Ljava/util/Map;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lb/a/a/d/d;

    .line 847
    if-nez v0, :cond_2

    .line 848
    const/4 v0, 0x0

    iget v3, p0, Lb/a/a/d/c;->d:I

    packed-switch v3, :pswitch_data_0

    :goto_0
    instance-of v3, v0, Ljava/text/SimpleDateFormat;

    if-nez v3, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "No datetime pattern for locale: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 852
    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 848
    :pswitch_0
    :try_start_1
    iget v0, p0, Lb/a/a/d/c;->b:I

    invoke-static {v0, p1}, Ljava/text/DateFormat;->getDateInstance(ILjava/util/Locale;)Ljava/text/DateFormat;

    move-result-object v0

    goto :goto_0

    :pswitch_1
    iget v0, p0, Lb/a/a/d/c;->c:I

    invoke-static {v0, p1}, Ljava/text/DateFormat;->getTimeInstance(ILjava/util/Locale;)Ljava/text/DateFormat;

    move-result-object v0

    goto :goto_0

    :pswitch_2
    iget v0, p0, Lb/a/a/d/c;->b:I

    iget v3, p0, Lb/a/a/d/c;->c:I

    invoke-static {v0, v3, p1}, Ljava/text/DateFormat;->getDateTimeInstance(IILjava/util/Locale;)Ljava/text/DateFormat;

    move-result-object v0

    goto :goto_0

    :cond_1
    check-cast v0, Ljava/text/SimpleDateFormat;

    invoke-virtual {v0}, Ljava/text/SimpleDateFormat;->toPattern()Ljava/lang/String;

    move-result-object v0

    .line 849
    invoke-static {v0}, Lb/a/a/d/a;->a(Ljava/lang/String;)Lb/a/a/d/d;

    move-result-object v0

    .line 850
    sget-object v3, Lb/a/a/d/c;->a:Ljava/util/Map;

    invoke-interface {v3, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 852
    :cond_2
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 853
    return-object v0

    .line 848
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 805
    const/16 v0, 0x28

    return v0
.end method

.method public final a(Lb/a/a/d/u;Ljava/lang/String;I)I
    .locals 1

    .prologue
    .line 837
    iget-object v0, p1, Lb/a/a/d/u;->d:Ljava/util/Locale;

    invoke-direct {p0, v0}, Lb/a/a/d/c;->a(Ljava/util/Locale;)Lb/a/a/d/d;

    move-result-object v0

    iget-object v0, v0, Lb/a/a/d/d;->b:Lb/a/a/d/t;

    .line 838
    invoke-interface {v0, p1, p2, p3}, Lb/a/a/d/t;->a(Lb/a/a/d/u;Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public final a(Ljava/lang/StringBuffer;JLb/a/a/a;ILb/a/a/i;Ljava/util/Locale;)V
    .locals 8

    .prologue
    .line 811
    invoke-direct {p0, p7}, Lb/a/a/d/c;->a(Ljava/util/Locale;)Lb/a/a/d/d;

    move-result-object v0

    iget-object v0, v0, Lb/a/a/d/d;->a:Lb/a/a/d/x;

    move-object v1, p1

    move-wide v2, p2

    move-object v4, p4

    move v5, p5

    move-object v6, p6

    move-object v7, p7

    .line 812
    invoke-interface/range {v0 .. v7}, Lb/a/a/d/x;->a(Ljava/lang/StringBuffer;JLb/a/a/a;ILb/a/a/i;Ljava/util/Locale;)V

    .line 813
    return-void
.end method

.method public final a(Ljava/lang/StringBuffer;Lb/a/a/aa;Ljava/util/Locale;)V
    .locals 1

    .prologue
    .line 823
    invoke-direct {p0, p3}, Lb/a/a/d/c;->a(Ljava/util/Locale;)Lb/a/a/d/d;

    move-result-object v0

    iget-object v0, v0, Lb/a/a/d/d;->a:Lb/a/a/d/x;

    .line 824
    invoke-interface {v0, p1, p2, p3}, Lb/a/a/d/x;->a(Ljava/lang/StringBuffer;Lb/a/a/aa;Ljava/util/Locale;)V

    .line 825
    return-void
.end method

.method public final b()I
    .locals 1

    .prologue
    .line 833
    const/16 v0, 0x28

    return v0
.end method
