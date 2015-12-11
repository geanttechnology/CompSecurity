.class public Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;


# direct methods
.method public constructor <init>(Landroid/app/Application;)V
    .locals 2

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    new-instance v0, Lcom/exacttarget/etpushsdk/ETPushConfig;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/exacttarget/etpushsdk/ETPushConfig;-><init>(Landroid/app/Application;Lcom/exacttarget/etpushsdk/ETPushConfig$1;)V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    .line 68
    return-void
.end method


# virtual methods
.method public build()Lcom/exacttarget/etpushsdk/ETPushConfig;
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 74
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 75
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "etAppId may not be null or empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 77
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->c:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 78
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "accessToken may not be null or empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 80
    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->d:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 81
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "gcmSenderId may not be null or empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 83
    :cond_2
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->j:Ljava/lang/Class;

    if-eqz v0, :cond_3

    .line 84
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->j:Ljava/lang/Class;

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/ETPush;->c(Ljava/lang/Class;Z)V

    .line 86
    :cond_3
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->k:Ljava/lang/Class;

    if-eqz v0, :cond_4

    .line 87
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->k:Ljava/lang/Class;

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/ETPush;->b(Ljava/lang/Class;Z)V

    .line 89
    :cond_4
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->l:Ljava/lang/Class;

    if-eqz v0, :cond_5

    .line 90
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->l:Ljava/lang/Class;

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Class;Z)V

    .line 92
    :cond_5
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->m:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 93
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->m:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/String;Z)V

    .line 95
    :cond_6
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->n:Landroid/net/Uri;

    if-eqz v0, :cond_7

    .line 96
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->n:Landroid/net/Uri;

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/ETPush;->a(Landroid/net/Uri;Z)V

    .line 98
    :cond_7
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->p:I

    if-lez v0, :cond_8

    .line 99
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->p:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Integer;Z)V

    .line 101
    :cond_8
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->o:I

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->setLogLevel(I)V

    .line 103
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    return-object v0
.end method

.method public setAccessToken(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-object p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->c:Ljava/lang/String;

    .line 113
    return-object p0
.end method

.method public setAnalyticsEnabled(Z)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-boolean p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->e:Z

    .line 123
    return-object p0
.end method

.method public setCloudPageRecipientClass(Ljava/lang/Class;)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-object p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->j:Ljava/lang/Class;

    .line 154
    return-object p0
.end method

.method public setCloudPagesEnabled(Z)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-boolean p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->i:Z

    .line 143
    return-object p0
.end method

.method public setEtAppId(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-object p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->b:Ljava/lang/String;

    .line 108
    return-object p0
.end method

.method public setGcmSenderId(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-object p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->d:Ljava/lang/String;

    .line 118
    return-object p0
.end method

.method public setLocationEnabled(Z)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-boolean p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->g:Z

    .line 133
    return-object p0
.end method

.method public setLogLevel(I)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 217
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->o:I

    .line 218
    return-object p0
.end method

.method public setLogToFile(Z)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 0

    .prologue
    .line 222
    return-object p0
.end method

.method public setNotificationAction(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 196
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-object p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->m:Ljava/lang/String;

    .line 197
    return-object p0
.end method

.method public setNotificationActionUri(Landroid/net/Uri;)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-object p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->n:Landroid/net/Uri;

    .line 186
    return-object p0
.end method

.method public setNotificationRecipientClass(Ljava/lang/Class;)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-object p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->l:Ljava/lang/Class;

    .line 175
    return-object p0
.end method

.method public setNotificationResourceId(I)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->p:I

    .line 208
    return-object p0
.end method

.method public setOpenDirectRecipientClass(Ljava/lang/Class;)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-object p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->k:Ljava/lang/Class;

    .line 165
    return-object p0
.end method

.method public setPiAnalyticsEnabled(Z)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-boolean p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->f:Z

    .line 128
    return-object p0
.end method

.method public setProximityEnabled(Z)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->pushConfig:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iput-boolean p1, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->h:Z

    .line 138
    return-object p0
.end method
