.class public Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private appointmentId:Ljava/lang/String;

.field private appointmentTime:J

.field private reminderTime:J

.field private storeAddress:Ljava/lang/String;

.field private storeCity:Ljava/lang/String;

.field private storeId:Ljava/lang/String;

.field private storeName:Ljava/lang/String;

.field private storeOpenTime:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppointmentId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->appointmentId:Ljava/lang/String;

    return-object v0
.end method

.method public getAppointmentTime()J
    .locals 2

    .prologue
    .line 32
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->appointmentTime:J

    return-wide v0
.end method

.method public getReminderTime()J
    .locals 2

    .prologue
    .line 40
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->reminderTime:J

    return-wide v0
.end method

.method public getStoreAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->storeAddress:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreCity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->storeCity:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->storeId:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->storeName:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreOpenTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->storeOpenTime:Ljava/lang/String;

    return-object v0
.end method

.method public setAppointmentId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->appointmentId:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setAppointmentTime(J)V
    .locals 1

    .prologue
    .line 36
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->appointmentTime:J

    .line 37
    return-void
.end method

.method public setReminderTime(J)V
    .locals 1

    .prologue
    .line 44
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->reminderTime:J

    .line 45
    return-void
.end method

.method public setStoreAddress(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->storeAddress:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public setStoreCity(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->storeCity:Ljava/lang/String;

    .line 61
    return-void
.end method

.method public setStoreId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->storeId:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setStoreName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->storeName:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public setStoreOpenTime(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->storeOpenTime:Ljava/lang/String;

    .line 85
    return-void
.end method
