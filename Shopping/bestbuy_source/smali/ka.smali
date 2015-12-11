.class public abstract Lka;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field protected b:Ljava/lang/String;

.field protected c:Ljava/lang/String;

.field protected d:Z

.field protected e:Z

.field protected f:Landroid/app/Activity;

.field protected g:Landroid/view/View;

.field protected h:Ljava/lang/Exception;

.field protected i:Lcom/bestbuy/android/base/BBYBaseFragment;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 36
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 26
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lka;->a:Ljava/lang/String;

    .line 37
    iput-boolean v1, p0, Lka;->d:Z

    .line 38
    iput-boolean v1, p0, Lka;->e:Z

    .line 39
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 26
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lka;->a:Ljava/lang/String;

    .line 42
    invoke-direct {p0, p1, p2}, Lka;->a(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 43
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V
    .locals 1

    .prologue
    .line 45
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 26
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lka;->a:Ljava/lang/String;

    .line 46
    iput-object p3, p0, Lka;->g:Landroid/view/View;

    .line 47
    invoke-direct {p0, p1, p2}, Lka;->a(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 48
    return-void
.end method

.method private a(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 51
    iput-object p1, p0, Lka;->f:Landroid/app/Activity;

    .line 52
    iput-object p2, p0, Lka;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 53
    iput-boolean v0, p0, Lka;->d:Z

    .line 54
    iput-boolean v0, p0, Lka;->e:Z

    .line 55
    return-void
.end method


# virtual methods
.method protected varargs a([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 175
    :try_start_0
    iget-object v0, p0, Lka;->f:Landroid/app/Activity;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lka;->f:Landroid/app/Activity;

    invoke-static {v0}, Llm;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 176
    const/4 v0, 0x1

    iput-boolean v0, p0, Lka;->e:Z
    :try_end_0
    .catch Lorg/apache/http/conn/ConnectTimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Llk; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_5

    .line 200
    :goto_0
    iget-object v0, p0, Lka;->c:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 201
    iget-object v0, p0, Lka;->c:Ljava/lang/String;

    iput-object v0, p0, Lka;->b:Ljava/lang/String;

    .line 203
    :cond_0
    const/4 v0, 0x0

    return-object v0

    .line 178
    :cond_1
    :try_start_1
    invoke-virtual {p0}, Lka;->a()V
    :try_end_1
    .catch Lorg/apache/http/conn/ConnectTimeoutException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/net/SocketException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/net/UnknownHostException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Llk; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_5

    goto :goto_0

    .line 180
    :catch_0
    move-exception v0

    .line 181
    iput-boolean v2, p0, Lka;->d:Z

    goto :goto_0

    .line 182
    :catch_1
    move-exception v0

    .line 183
    iput-boolean v2, p0, Lka;->d:Z

    goto :goto_0

    .line 184
    :catch_2
    move-exception v0

    .line 185
    iput-boolean v2, p0, Lka;->d:Z

    goto :goto_0

    .line 186
    :catch_3
    move-exception v0

    .line 187
    iput-boolean v2, p0, Lka;->d:Z

    goto :goto_0

    .line 188
    :catch_4
    move-exception v0

    .line 189
    iget-object v1, p0, Lka;->a:Ljava/lang/String;

    invoke-static {v1, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 190
    invoke-virtual {v0}, Llk;->a()Lorg/apache/http/HttpResponse;

    move-result-object v1

    invoke-interface {v1}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v1

    invoke-interface {v1}, Lorg/apache/http/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lka;->b:Ljava/lang/String;

    .line 191
    iput-boolean v2, p0, Lka;->d:Z

    .line 192
    iput-object v0, p0, Lka;->h:Ljava/lang/Exception;

    goto :goto_0

    .line 193
    :catch_5
    move-exception v0

    .line 194
    iget-object v1, p0, Lka;->a:Ljava/lang/String;

    invoke-static {v1, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 195
    iput-boolean v2, p0, Lka;->d:Z

    .line 196
    iput-object v0, p0, Lka;->h:Ljava/lang/Exception;

    goto :goto_0
.end method

.method public abstract a()V
.end method

.method protected a_(Ljava/lang/Void;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 143
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 144
    iget-object v0, p0, Lka;->f:Landroid/app/Activity;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lka;->f:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 169
    :cond_0
    :goto_0
    return-void

    .line 147
    :cond_1
    iget-boolean v0, p0, Lka;->e:Z

    if-nez v0, :cond_2

    iget-boolean v0, p0, Lka;->d:Z

    if-eqz v0, :cond_5

    :cond_2
    iget-object v0, p0, Lka;->f:Landroid/app/Activity;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lka;->f:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_5

    .line 149
    iget-object v0, p0, Lka;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lka;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 150
    iget-object v0, p0, Lka;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragment;->d(Z)V

    .line 151
    invoke-virtual {p0}, Lka;->c()V

    .line 160
    :goto_1
    iget-object v0, p0, Lka;->f:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    if-eqz v0, :cond_0

    .line 161
    invoke-virtual {p0}, Lka;->c()V

    goto :goto_0

    .line 154
    :cond_3
    iget-object v0, p0, Lka;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_4

    .line 155
    iget-object v0, p0, Lka;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragment;->d(Z)V

    goto :goto_1

    .line 157
    :cond_4
    invoke-virtual {p0}, Lka;->c()V

    goto :goto_1

    .line 164
    :cond_5
    iget-object v0, p0, Lka;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_6

    .line 165
    iget-object v0, p0, Lka;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragment;->d(Z)V

    .line 167
    :cond_6
    invoke-virtual {p0}, Lka;->b()V

    goto :goto_0
.end method

.method public abstract b()V
.end method

.method public c()V
    .locals 0

    .prologue
    .line 113
    return-void
.end method

.method public d()V
    .locals 0

    .prologue
    .line 82
    return-void
.end method

.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 25
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lka;->a([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public e()V
    .locals 0

    .prologue
    .line 96
    return-void
.end method

.method protected synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 25
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lka;->a_(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 208
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 209
    iget-object v0, p0, Lka;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 210
    iget-object v0, p0, Lka;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 212
    :cond_0
    invoke-virtual {p0}, Lka;->e()V

    .line 213
    return-void
.end method
