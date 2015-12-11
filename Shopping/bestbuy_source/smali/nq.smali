.class public Lnq;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/hardware/SensorEventListener;


# instance fields
.field private a:F

.field private b:[F

.field private c:D

.field private d:D

.field private e:F


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const v0, 0x411ce80a

    iput v0, p0, Lnq;->a:F

    .line 23
    const-wide/high16 v0, 0x4050000000000000L    # 64.0

    iput-wide v0, p0, Lnq;->c:D

    .line 24
    const-wide/high16 v0, 0x4039000000000000L    # 25.0

    iput-wide v0, p0, Lnq;->d:D

    .line 25
    const/high16 v0, 0x41500000    # 13.0f

    iput v0, p0, Lnq;->e:F

    return-void
.end method


# virtual methods
.method a(Landroid/hardware/SensorEvent;)V
    .locals 8

    .prologue
    const/4 v3, 0x1

    .line 38
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 39
    const-string v1, "shake_your_device"

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 40
    const-string v1, "On"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 41
    iget-object v0, p1, Landroid/hardware/SensorEvent;->sensor:Landroid/hardware/Sensor;

    invoke-virtual {v0}, Landroid/hardware/Sensor;->getType()I

    move-result v0

    if-ne v0, v3, :cond_0

    .line 42
    iget-object v0, p1, Landroid/hardware/SensorEvent;->values:[F

    invoke-virtual {v0}, [F->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [F

    iget-object v1, p0, Lnq;->b:[F

    invoke-virtual {p0, v0, v1}, Lnq;->a([F[F)[F

    move-result-object v0

    iput-object v0, p0, Lnq;->b:[F

    .line 44
    :cond_0
    iget-object v0, p0, Lnq;->b:[F

    if-eqz v0, :cond_4

    .line 45
    iget-object v0, p0, Lnq;->b:[F

    const/4 v1, 0x0

    aget v0, v0, v1

    .line 46
    iget-object v1, p0, Lnq;->b:[F

    aget v1, v1, v3

    .line 47
    iget-object v2, p0, Lnq;->b:[F

    const/4 v3, 0x2

    aget v2, v2, v3

    .line 48
    mul-float/2addr v0, v0

    float-to-double v4, v0

    .line 49
    mul-float v0, v1, v1

    float-to-double v0, v0

    .line 50
    mul-float/2addr v2, v2

    float-to-double v2, v2

    .line 51
    add-double v6, v4, v0

    add-double/2addr v6, v2

    invoke-static {v6, v7}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v6

    double-to-float v6, v6

    iput v6, p0, Lnq;->a:F

    .line 53
    iget v6, p0, Lnq;->a:F

    iget v7, p0, Lnq;->e:F

    cmpl-float v6, v6, v7

    if-lez v6, :cond_4

    iget-wide v6, p0, Lnq;->c:D

    cmpl-double v6, v4, v6

    if-lez v6, :cond_1

    iget-wide v6, p0, Lnq;->c:D

    cmpl-double v6, v0, v6

    if-lez v6, :cond_1

    iget-wide v6, p0, Lnq;->d:D

    cmpl-double v6, v2, v6

    if-gtz v6, :cond_3

    :cond_1
    iget-wide v6, p0, Lnq;->c:D

    cmpl-double v6, v4, v6

    if-lez v6, :cond_2

    iget-wide v6, p0, Lnq;->d:D

    cmpl-double v6, v0, v6

    if-lez v6, :cond_2

    iget-wide v6, p0, Lnq;->c:D

    cmpl-double v6, v2, v6

    if-gtz v6, :cond_3

    :cond_2
    iget-wide v6, p0, Lnq;->d:D

    cmpl-double v4, v4, v6

    if-lez v4, :cond_4

    iget-wide v4, p0, Lnq;->c:D

    cmpl-double v0, v0, v4

    if-lez v0, :cond_4

    iget-wide v0, p0, Lnq;->c:D

    cmpl-double v0, v2, v0

    if-lez v0, :cond_4

    .line 57
    :cond_3
    new-instance v0, Landroid/content/Intent;

    invoke-static {}, Lcom/bestbuy/android/base/BBYApplication;->getInstance()Lcom/bestbuy/android/base/BBYApplication;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/base/BBYApplication;->getBaseContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 58
    sget-object v1, Lnb;->k:Ljava/lang/String;

    sget-object v2, Lnb;->n:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 59
    const/high16 v1, 0x14000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 60
    invoke-static {}, Lcom/bestbuy/android/base/BBYApplication;->getInstance()Lcom/bestbuy/android/base/BBYApplication;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/base/BBYApplication;->getBaseContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 65
    :cond_4
    return-void
.end method

.method protected a([F[F)[F
    .locals 5

    .prologue
    .line 68
    if-nez p2, :cond_0

    .line 73
    :goto_0
    return-object p1

    .line 70
    :cond_0
    const/4 v0, 0x0

    :goto_1
    array-length v1, p1

    if-ge v0, v1, :cond_1

    .line 71
    aget v1, p2, v0

    const/high16 v2, 0x3e800000    # 0.25f

    aget v3, p1, v0

    aget v4, p2, v0

    sub-float/2addr v3, v4

    mul-float/2addr v2, v3

    add-float/2addr v1, v2

    aput v1, p2, v0

    .line 70
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_1
    move-object p1, p2

    .line 73
    goto :goto_0
.end method

.method public onAccuracyChanged(Landroid/hardware/Sensor;I)V
    .locals 0

    .prologue
    .line 35
    return-void
.end method

.method public onSensorChanged(Landroid/hardware/SensorEvent;)V
    .locals 0

    .prologue
    .line 29
    invoke-virtual {p0, p1}, Lnq;->a(Landroid/hardware/SensorEvent;)V

    .line 30
    return-void
.end method
