.class public Lcom/poshmark/ui/model/ActionErrorContext;
.super Ljava/lang/Object;
.source "ActionErrorContext.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/model/ActionErrorContext$1;,
        Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;,
        Lcom/poshmark/ui/model/ActionErrorContext$Severity;
    }
.end annotation


# instance fields
.field public final analyticsEvent:Ljava/lang/String;

.field public final message:Ljava/lang/String;

.field public final severity:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

.field public final title:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V
    .locals 7
    .param p1, "pmApiError"    # Lcom/poshmark/http/api/PMApiError;
    .param p2, "actionContext"    # Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    .prologue
    const/4 v3, 0x0

    .line 221
    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->LOW:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v5, v3

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;Ljava/lang/String;Ljava/lang/String;)V

    .line 222
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V
    .locals 7
    .param p1, "pmApiError"    # Lcom/poshmark/http/api/PMApiError;
    .param p2, "actionContext"    # Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;
    .param p3, "severity"    # Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    .prologue
    const/4 v3, 0x0

    .line 229
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    move-object v5, v3

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V
    .locals 7
    .param p1, "pmApiError"    # Lcom/poshmark/http/api/PMApiError;
    .param p2, "actionContext"    # Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;
    .param p3, "operation"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 225
    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->LOW:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v6, v5

    invoke-direct/range {v0 .. v6}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V
    .locals 7
    .param p1, "pmApiError"    # Lcom/poshmark/http/api/PMApiError;
    .param p2, "actionContext"    # Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;
    .param p3, "operation"    # Ljava/lang/String;
    .param p4, "severity"    # Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    .prologue
    const/4 v5, 0x0

    .line 233
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v6, v5

    invoke-direct/range {v0 .. v6}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;Ljava/lang/String;Ljava/lang/String;)V

    .line 234
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "pmApiError"    # Lcom/poshmark/http/api/PMApiError;
    .param p2, "actionContext"    # Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;
    .param p3, "operation"    # Ljava/lang/String;
    .param p4, "severity"    # Lcom/poshmark/ui/model/ActionErrorContext$Severity;
    .param p5, "networkErrorMessage"    # Ljava/lang/String;
    .param p6, "otherErrorMessage"    # Ljava/lang/String;

    .prologue
    .line 236
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 237
    iput-object p4, p0, Lcom/poshmark/ui/model/ActionErrorContext;->severity:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    .line 238
    invoke-direct {p0, p2}, Lcom/poshmark/ui/model/ActionErrorContext;->getAnalyticsEvent(Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/model/ActionErrorContext;->analyticsEvent:Ljava/lang/String;

    .line 239
    invoke-direct {p0, p1}, Lcom/poshmark/ui/model/ActionErrorContext;->getTitle(Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/model/ActionErrorContext;->title:Ljava/lang/String;

    .line 240
    invoke-direct {p0, p1, p3, p5, p6}, Lcom/poshmark/ui/model/ActionErrorContext;->getMessage(Lcom/poshmark/http/api/PMApiError;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/model/ActionErrorContext;->message:Ljava/lang/String;

    .line 241
    return-void
.end method

.method private getAnalyticsEvent(Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)Ljava/lang/String;
    .locals 3
    .param p1, "actionContext"    # Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    .prologue
    .line 303
    invoke-static {p1}, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->getString(Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)Ljava/lang/String;

    move-result-object v0

    .line 304
    .local v0, "actionContextString":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 305
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_error"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 307
    :goto_0
    return-object v1

    :cond_0
    const-string v1, "unknown_error"

    goto :goto_0
.end method

.method private getMessage(Lcom/poshmark/http/api/PMApiError;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p1, "pmApiError"    # Lcom/poshmark/http/api/PMApiError;
    .param p2, "operation"    # Ljava/lang/String;
    .param p3, "networkErrorMessage"    # Ljava/lang/String;
    .param p4, "otherErrorMessage"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 246
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 249
    .local v0, "context":Landroid/content/Context;
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiError;->getUserMessage()Ljava/lang/String;

    move-result-object v1

    .line 250
    .local v1, "userMessage":Ljava/lang/String;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 294
    .end local v1    # "userMessage":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 255
    .restart local v1    # "userMessage":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiError;->isNetworkDomainError()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 258
    if-eqz p3, :cond_1

    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    move-object v1, p3

    .line 259
    goto :goto_0

    .line 263
    :cond_1
    invoke-static {}, Lcom/poshmark/utils/NetworkUtils;->isOnline()Z

    move-result v2

    if-nez v2, :cond_3

    .line 265
    if-eqz p2, :cond_2

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_2

    .line 266
    const v2, 0x7f0600f1

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p2, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 269
    :cond_2
    const v2, 0x7f0600f0

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 274
    :cond_3
    if-eqz p2, :cond_4

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_4

    .line 275
    const v2, 0x7f0600f3

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p2, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 278
    :cond_4
    const v2, 0x7f0600f2

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 282
    :cond_5
    if-eqz p4, :cond_6

    invoke-virtual {p4}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_6

    move-object v1, p4

    .line 285
    goto :goto_0

    .line 287
    :cond_6
    if-eqz p2, :cond_7

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_7

    .line 290
    const v2, 0x7f0600d9

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p2, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 294
    :cond_7
    const v2, 0x7f0600d8

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method private static getSeverity(Lcom/poshmark/http/api/PMApiError;)Lcom/poshmark/ui/model/ActionErrorContext$Severity;
    .locals 2
    .param p0, "pmApiError"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 311
    invoke-virtual {p0}, Lcom/poshmark/http/api/PMApiError;->getUserMessage()Ljava/lang/String;

    move-result-object v0

    .line 312
    .local v0, "userMessage":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 313
    sget-object v1, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    .line 315
    :goto_0
    return-object v1

    :cond_0
    sget-object v1, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->LOW:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    goto :goto_0
.end method

.method private getTitle(Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;
    .locals 1
    .param p1, "pmApiError"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 298
    const/4 v0, 0x0

    return-object v0
.end method
