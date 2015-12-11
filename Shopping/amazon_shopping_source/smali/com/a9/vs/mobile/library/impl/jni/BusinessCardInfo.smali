.class public Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;
.super Ljava/lang/Object;
.source "BusinessCardInfo.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 120
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_BusinessCardInfo()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;-><init>(JZ)V

    .line 121
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
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    .line 18
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

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
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_BusinessCardInfo(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J
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
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->delete()V

    .line 26
    return-void
.end method

.method public getAddress()Lcom/a9/vs/mobile/library/impl/jni/Address;
    .locals 4

    .prologue
    .line 52
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_address_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J

    move-result-wide v0

    .line 53
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/Address;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/Address;-><init>(JZ)V

    goto :goto_0
.end method

.method public getCompany()Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;
    .locals 4

    .prologue
    .line 61
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_company_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J

    move-result-wide v0

    .line 62
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;-><init>(JZ)V

    goto :goto_0
.end method

.method public getDepartment()Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;
    .locals 4

    .prologue
    .line 79
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_department_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J

    move-result-wide v0

    .line 80
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;-><init>(JZ)V

    goto :goto_0
.end method

.method public getEmails()Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;
    .locals 4

    .prologue
    .line 97
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_emails_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J

    move-result-wide v0

    .line 98
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;-><init>(JZ)V

    goto :goto_0
.end method

.method public getJobTitle()Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;
    .locals 4

    .prologue
    .line 70
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_jobTitle_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J

    move-result-wide v0

    .line 71
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;-><init>(JZ)V

    goto :goto_0
.end method

.method public getName()Lcom/a9/vs/mobile/library/impl/jni/Name;
    .locals 4

    .prologue
    .line 43
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_name_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J

    move-result-wide v0

    .line 44
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/Name;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/Name;-><init>(JZ)V

    goto :goto_0
.end method

.method public getOtherText()Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;
    .locals 4

    .prologue
    .line 115
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_otherText_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J

    move-result-wide v0

    .line 116
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;-><init>(JZ)V

    goto :goto_0
.end method

.method public getPhones()Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;
    .locals 4

    .prologue
    .line 88
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_phones_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J

    move-result-wide v0

    .line 89
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;-><init>(JZ)V

    goto :goto_0
.end method

.method public getUrls()Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;
    .locals 4

    .prologue
    .line 106
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_urls_get(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J

    move-result-wide v0

    .line 107
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;-><init>(JZ)V

    goto :goto_0
.end method

.method public setAddress(Lcom/a9/vs/mobile/library/impl/jni/Address;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/Address;

    .prologue
    .line 48
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/Address;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/Address;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_address_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/Address;)V

    .line 49
    return-void
.end method

.method public setCompany(Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;

    .prologue
    .line 57
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_company_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)V

    .line 58
    return-void
.end method

.method public setDepartment(Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_department_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)V

    .line 76
    return-void
.end method

.method public setEmails(Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;

    .prologue
    .line 93
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_emails_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V

    .line 94
    return-void
.end method

.method public setJobTitle(Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;

    .prologue
    .line 66
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_jobTitle_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/BusinessCardEntity;)V

    .line 67
    return-void
.end method

.method public setName(Lcom/a9/vs/mobile/library/impl/jni/Name;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/Name;

    .prologue
    .line 39
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/Name;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/Name;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_name_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/Name;)V

    .line 40
    return-void
.end method

.method public setOtherText(Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;

    .prologue
    .line 111
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_otherText_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V

    .line 112
    return-void
.end method

.method public setPhones(Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;

    .prologue
    .line 84
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_phones_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V

    .line 85
    return-void
.end method

.method public setUrls(Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;

    .prologue
    .line 102
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->BusinessCardInfo_urls_set(JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfBusinessCardEntities;)V

    .line 103
    return-void
.end method
