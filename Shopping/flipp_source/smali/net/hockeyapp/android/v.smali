.class public Lnet/hockeyapp/android/v;
.super Landroid/app/DialogFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lnet/hockeyapp/android/x;


# instance fields
.field private downloadTask:Lnet/hockeyapp/android/d/d;

.field private urlString:Ljava/lang/String;

.field private versionHelper:Lnet/hockeyapp/android/e/i;

.field private versionInfo:Lorg/json/JSONArray;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 60
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lnet/hockeyapp/android/v;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 60
    invoke-direct {p0, p1}, Lnet/hockeyapp/android/v;->startDownloadTask(Landroid/app/Activity;)V

    return-void
.end method

.method public static newInstance(Lorg/json/JSONArray;Ljava/lang/String;)Lnet/hockeyapp/android/v;
    .locals 3

    .prologue
    .line 89
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 90
    const-string v1, "url"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    const-string v1, "versionInfo"

    invoke-virtual {p0}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    new-instance v1, Lnet/hockeyapp/android/v;

    invoke-direct {v1}, Lnet/hockeyapp/android/v;-><init>()V

    .line 94
    invoke-virtual {v1, v0}, Lnet/hockeyapp/android/v;->setArguments(Landroid/os/Bundle;)V

    .line 95
    return-object v1
.end method

.method private startDownloadTask(Landroid/app/Activity;)V
    .locals 3

    .prologue
    .line 164
    new-instance v0, Lnet/hockeyapp/android/d/d;

    iget-object v1, p0, Lnet/hockeyapp/android/v;->urlString:Ljava/lang/String;

    new-instance v2, Lnet/hockeyapp/android/w;

    invoke-direct {v2, p0, p1}, Lnet/hockeyapp/android/w;-><init>(Lnet/hockeyapp/android/v;Landroid/app/Activity;)V

    invoke-direct {v0, p1, v1, v2}, Lnet/hockeyapp/android/d/d;-><init>(Landroid/content/Context;Ljava/lang/String;Lnet/hockeyapp/android/b/a;)V

    iput-object v0, p0, Lnet/hockeyapp/android/v;->downloadTask:Lnet/hockeyapp/android/d/d;

    .line 185
    iget-object v0, p0, Lnet/hockeyapp/android/v;->downloadTask:Lnet/hockeyapp/android/d/d;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-virtual {v0, v1}, Lnet/hockeyapp/android/d/d;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 186
    return-void
.end method


# virtual methods
.method public getAppName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 213
    invoke-virtual {p0}, Lnet/hockeyapp/android/v;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 216
    :try_start_0
    invoke-virtual {v0}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 217
    invoke-virtual {v0}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 218
    invoke-virtual {v1, v0}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 221
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v0, ""

    goto :goto_0
.end method

.method public getCurrentVersionCode()I
    .locals 4

    .prologue
    .line 194
    const/4 v0, -0x1

    .line 197
    :try_start_0
    invoke-virtual {p0}, Lnet/hockeyapp/android/v;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {p0}, Lnet/hockeyapp/android/v;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x80

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    iget v0, v1, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    .line 204
    :goto_0
    return v0

    :catch_0
    move-exception v1

    goto :goto_0

    .line 202
    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method public getLayoutView()Landroid/view/View;
    .locals 4

    .prologue
    .line 231
    new-instance v0, Lnet/hockeyapp/android/f/c;

    invoke-virtual {p0}, Lnet/hockeyapp/android/v;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-direct {v0, v1, v2, v3}, Lnet/hockeyapp/android/f/c;-><init>(Landroid/content/Context;ZZ)V

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 155
    invoke-virtual {p0}, Lnet/hockeyapp/android/v;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-direct {p0, v0}, Lnet/hockeyapp/android/v;->startDownloadTask(Landroid/app/Activity;)V

    .line 156
    invoke-virtual {p0}, Lnet/hockeyapp/android/v;->dismiss()V

    .line 157
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 107
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onCreate(Landroid/os/Bundle;)V

    .line 110
    :try_start_0
    invoke-virtual {p0}, Lnet/hockeyapp/android/v;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "url"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/hockeyapp/android/v;->urlString:Ljava/lang/String;

    .line 111
    new-instance v0, Lorg/json/JSONArray;

    invoke-virtual {p0}, Lnet/hockeyapp/android/v;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "versionInfo"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lnet/hockeyapp/android/v;->versionInfo:Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 118
    const/4 v0, 0x1

    const v1, 0x1030073

    invoke-virtual {p0, v0, v1}, Lnet/hockeyapp/android/v;->setStyle(II)V

    .line 119
    :goto_0
    return-void

    .line 114
    :catch_0
    move-exception v0

    invoke-virtual {p0}, Lnet/hockeyapp/android/v;->dismiss()V

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7

    .prologue
    .line 129
    invoke-virtual {p0}, Lnet/hockeyapp/android/v;->getLayoutView()Landroid/view/View;

    move-result-object v6

    .line 131
    new-instance v0, Lnet/hockeyapp/android/e/i;

    iget-object v1, p0, Lnet/hockeyapp/android/v;->versionInfo:Lorg/json/JSONArray;

    invoke-virtual {v1}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p0}, Lnet/hockeyapp/android/e/i;-><init>(Ljava/lang/String;Lnet/hockeyapp/android/x;)V

    iput-object v0, p0, Lnet/hockeyapp/android/v;->versionHelper:Lnet/hockeyapp/android/e/i;

    .line 133
    const/16 v0, 0x1002

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 134
    invoke-virtual {p0}, Lnet/hockeyapp/android/v;->getAppName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 136
    const/16 v0, 0x1003

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 137
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Version "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lnet/hockeyapp/android/v;->versionHelper:Lnet/hockeyapp/android/e/i;

    invoke-virtual {v2}, Lnet/hockeyapp/android/e/i;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lnet/hockeyapp/android/v;->versionHelper:Lnet/hockeyapp/android/e/i;

    invoke-virtual {v2}, Lnet/hockeyapp/android/e/i;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 139
    const/16 v0, 0x1004

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 140
    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    const/16 v0, 0x1005

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    .line 143
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->clearCache(Z)V

    .line 144
    invoke-virtual {v0}, Landroid/webkit/WebView;->destroyDrawingCache()V

    .line 145
    const-string v1, "https://sdk.hockeyapp.net/"

    iget-object v2, p0, Lnet/hockeyapp/android/v;->versionHelper:Lnet/hockeyapp/android/e/i;

    invoke-virtual {v2}, Lnet/hockeyapp/android/e/i;->c()Ljava/lang/String;

    move-result-object v2

    const-string v3, "text/html"

    const-string v4, "utf-8"

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    return-object v6
.end method
