.class public Lcom/a9/vs/mobile/library/impl/jni/Address;
.super Ljava/lang/Object;
.source "Address.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 39
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_Address()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/Address;-><init>(JZ)V

    .line 40
    return-void
.end method

.method protected constructor <init>(JZ)V
    .locals 0
    .param p1, "cPtr"    # J
    .param p3, "cMemoryOwn"    # Z

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    .line 18
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/Address;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/Address;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized delete()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 29
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_Address(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 36
    :cond_1
    monitor-exit p0

    return-void

    .line 29
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected finalize()V
    .locals 0

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/Address;->delete()V

    .line 26
    return-void
.end method

.method public getCity()Ljava/lang/String;
    .locals 2

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->Address_city_get(JLcom/a9/vs/mobile/library/impl/jni/Address;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getIsVerified()Z
    .locals 2

    .prologue
    .line 87
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->Address_isVerified_get(JLcom/a9/vs/mobile/library/impl/jni/Address;)Z

    move-result v0

    return v0
.end method

.method public getState_abbr()Ljava/lang/String;
    .locals 2

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->Address_state_abbr_get(JLcom/a9/vs/mobile/library/impl/jni/Address;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getState_full()Ljava/lang/String;
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->Address_state_full_get(JLcom/a9/vs/mobile/library/impl/jni/Address;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getStreet()Ljava/lang/String;
    .locals 2

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->Address_street_get(JLcom/a9/vs/mobile/library/impl/jni/Address;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getZipcode()Ljava/lang/String;
    .locals 2

    .prologue
    .line 79
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->Address_zipcode_get(JLcom/a9/vs/mobile/library/impl/jni/Address;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setCity(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->Address_city_set(JLcom/a9/vs/mobile/library/impl/jni/Address;Ljava/lang/String;)V

    .line 52
    return-void
.end method

.method public setIsVerified(Z)V
    .locals 2
    .param p1, "value"    # Z

    .prologue
    .line 83
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->Address_isVerified_set(JLcom/a9/vs/mobile/library/impl/jni/Address;Z)V

    .line 84
    return-void
.end method

.method public setState_abbr(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->Address_state_abbr_set(JLcom/a9/vs/mobile/library/impl/jni/Address;Ljava/lang/String;)V

    .line 60
    return-void
.end method

.method public setState_full(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->Address_state_full_set(JLcom/a9/vs/mobile/library/impl/jni/Address;Ljava/lang/String;)V

    .line 68
    return-void
.end method

.method public setStreet(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->Address_street_set(JLcom/a9/vs/mobile/library/impl/jni/Address;Ljava/lang/String;)V

    .line 44
    return-void
.end method

.method public setZipcode(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/Address;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->Address_zipcode_set(JLcom/a9/vs/mobile/library/impl/jni/Address;Ljava/lang/String;)V

    .line 76
    return-void
.end method
